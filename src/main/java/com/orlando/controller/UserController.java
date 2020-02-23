package com.orlando.controller;

import com.orlando.domain.User;
import com.orlando.service.UserService;
import com.orlando.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

 /*   @GetMapping("/")
    public String root() {
        return "home";
    }*/

    @GetMapping("/login")
    public String login(Model model) {
        return "user/login";
    }

    @ModelAttribute("/registration")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "user/registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "user/registration";
        }

        userService.save(userDto);
        return "redirect:user/registration?success";
    }

  /*  @GetMapping("/user")
    public String usersHome() {
        return "user/home";
    }*/

}
