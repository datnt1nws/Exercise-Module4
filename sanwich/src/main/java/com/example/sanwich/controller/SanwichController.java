package com.example.sanwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Controller
public class SanwichController {
    private static final List<String> CONDIMENTS = Arrays.asList("Lecttuce", "Tomato","Mutard", "Sprouts" );

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("condiments", CONDIMENTS);
        return "index" ;
    }

    @PostMapping("/save")
    public String save(@RequestParam (value = "condiment", required = false) String[] condiment, Model model) {
        List<String> selectedCondiments = (condiment != null) ? Arrays.asList(condiment) : Arrays.asList("No condiments selected");
        model.addAttribute("selectedCondiments", selectedCondiments);
        return "result" ;
    }
}
