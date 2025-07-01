package com.example.validate.controller;

import com.example.validate.model.User;
import com.example.validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String redirectToRegister() {
        return "redirect:/register"; // Redirect từ / đến /register
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String submitForm(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        userService.saveUser(user);
        return "result";
    }
}