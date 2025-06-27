package com.example.ProductDemo.service;


import com.example.ProductDemo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void delete(Long id);
    List<Product> findByName(String name);
}