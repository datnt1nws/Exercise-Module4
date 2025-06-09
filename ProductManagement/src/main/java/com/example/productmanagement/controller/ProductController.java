package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "list";
    }

    @PostMapping("/add")
    public String addProduct(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam String description,
            @RequestParam String manufacturer,
            Model model) {
        Product product = new Product(id, name, price, description, manufacturer);
        productService.addProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String updateProduct(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam String description,
            @RequestParam String manufacturer,
            Model model) {
        Product product = new Product(id, name, price, description, manufacturer);
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}