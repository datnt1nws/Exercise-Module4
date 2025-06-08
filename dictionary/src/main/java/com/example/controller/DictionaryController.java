package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("goodbye", "tạm biệt");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "word", required = false) String word, Model model) {
        if (word != null && dictionary.containsKey(word.toLowerCase())) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", dictionary.get(word.toLowerCase()));
        } else {
            model.addAttribute("message", "Không tìm thấy từ này!");
        }
        return "result";
    }
}