package com.example.productmanagement.service;

import java.util.List;
import com.example.productmanagement.model.Product;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
    Product getProductById(Long id);
}
