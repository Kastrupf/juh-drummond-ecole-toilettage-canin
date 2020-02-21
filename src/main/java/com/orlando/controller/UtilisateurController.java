package com.orlando.controller;

import com.orlando.domain.Utilisateur;
import com.orlando.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("utilisateurs")
public class UtilisateurController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

   @GetMapping("/login")
    public String preLogin(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur) {

        return "/utilisateur/login";
    }


    @PostMapping("/login")
    public String seConnecter(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/utilisateur/login";
        }

        loginServiceImpl.checkLogin(utilisateur);
        attr.addFlashAttribute("mensagem", "Vous êtes connecté");
        return "redirect:/client/list";
    }
}
