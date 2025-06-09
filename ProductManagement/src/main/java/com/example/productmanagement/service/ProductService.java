package com.example.productmanagement.service;

import java.util.List;
import java.util.ArrayList;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.ProductService;

public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}