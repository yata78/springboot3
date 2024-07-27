package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person , Integer>{
    
    public Optional<Person> findById(Integer id);
}
