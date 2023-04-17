package com.vrx.oauth.controller;

import com.vrx.oauth.dto.UserRegistrationDto;
import com.vrx.oauth.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRegistrationDto userRegistrationDto;

    @Autowired
    private RegistrationService registrationService;


    @GetMapping
    public String showRegistrationForm(@ModelAttribute("user") UserRegistrationDto user) {
        user = this.userRegistrationDto;
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto user) {
        registrationService.registerUser(user);
        return "redirect:/login";
    }
}
