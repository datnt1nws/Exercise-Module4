package com.example.controller;

import com.example.model.ConverterForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ConverterController {
    @GetMapping("/convert")
    public String showForm(Model model) {
        model.addAttribute("converterForm" , new ConverterForm());
        return "convert";
    }

    @PostMapping("/")
    public String convert(@ModelAttribute ConverterForm converterForm, Model model){
        double usd = converterForm.getUsd();
        double rate = converterForm.getRate();
        double vnd = usd * rate;
        model.addAttribute("result", vnd);
        return "convert";
    }
}
