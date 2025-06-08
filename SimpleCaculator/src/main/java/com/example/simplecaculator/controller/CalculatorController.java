package com.example.simplecaculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
    @RequestMapping("/calculator")
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operation") String operation,
                            Model model) {
        double result = 0;
        switch (operation) {
            case "addition":
                result = num1 + num2;
                break;
            case "subtraction":
                result = num1 - num2;
                break;
            case "multiplication":
                result = num1 * num2;
                break;
            case "division":
                if (num2 != 0) result = num1 / num2;
                else result = 0; // Xử lý chia cho 0
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("operation", operation);
        return "result"; // Trả về view result.jsp
    }
}