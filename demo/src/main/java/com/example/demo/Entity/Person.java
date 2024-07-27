package com.example.demo.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "people")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    int Id;

    @Column(length = 50, nullable = false)
    String name;

    @Column(length = 200, nullable = true)
    String mail;

    @Column(nullable = true)
    int age;

    @Column(nullable = true)
    String memo;
}
