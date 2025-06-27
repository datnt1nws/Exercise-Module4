package com.example.ProductDemo.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseRepository<T, ID extends Serializable> implements IBaseRepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected SessionFactory sessionFactory;

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseRepository() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Override
    public T findById(ID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(entityClass, id);
    }

    @Override
    public void save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(ID id) {
        Session session = sessionFactory.getCurrentSession();
        T entity = findById(id);
        if (entity != null) {
            session.delete(entity);
        }
    }
}