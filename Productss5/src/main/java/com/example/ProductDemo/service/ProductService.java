package com.example.ProductDemo.service;



import com.example.ProductDemo.model.Product;
import com.example.ProductDemo.repository.BaseRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService extends BaseRepository<Product, Long> implements IProductService {

    @Override
    public List<Product> findAll() {
        return super.findAll();
    }

    @Override
    public Product findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void save(Product product) {
        super.save(product);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Product WHERE name LIKE :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}