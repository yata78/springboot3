package com.example.demo;

import javax.management.Query;

import org.hibernate.mapping.List;

import com.example.demo.Entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonDaoImpl implements PersonDao<Person>{
    private static final long serialVersionUID = 1;

    @PersistenceContext
    private EntityManager entityManager;

    public PersonDaoImpl() {
        super();
    }

    @Override
    public java.util.List<Person> getAll() {
        jakarta.persistence.Query query = entityManager.createQuery("from Person");
        @SuppressWarnings("unchecked")
        java.util.List<Person> list = query.getResultList();
        entityManager.close();
        return list;
    }
    
    @Override
    public Person findById(Integer id) {
        return (Person)entityManager.createQuery("from Person where id = " + id).getSingleResult();
    }

    @Override
    public java.util.List<Person> findByName(String name) {
        return ((java.util.List<Person>)entityManager.createQuery("from Person where name = '" + name + "'").getResultList());

    }
}

