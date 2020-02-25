package com.orlando.web.controller;

import com.orlando.domain.Client;
import com.orlando.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String root() {
        return "home";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("client", clientService.recuperer());
        return new ModelAndView("/client/list", model);
    }

    @GetMapping("/contact")
    public String preSave(@ModelAttribute("client") Client client) {
        return "client/add";
    }

    @PostMapping("/enregistrer")
    public String save(@Valid @ModelAttribute("client") Client client, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/client/add";
        }

        clientService.enregistrer(client);
        attr.addFlashAttribute("mensagem", "Votre message a été bien envoyée");
        return "redirect:/client/contact";
    }

    @GetMapping("/id")
    public ModelAndView recupererParID(Integer id, ModelMap model) {
        Client client = clientService.recupererParID(id);
        model.addAttribute("client", client);
        return new ModelAndView("/client/add", model);
    }

}
