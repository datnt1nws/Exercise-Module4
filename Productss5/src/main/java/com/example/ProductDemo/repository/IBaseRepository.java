package com.example.ProductDemo.repository;

import java.io.Serializable;
import java.util.List;

public interface IBaseRepository<T, ID extends Serializable> {
    List<T> findAll();
    T findById(ID id);
    void save(T entity);
    void delete(ID id);
}