package com.example.demo.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "people")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Integer Id;

    @Column(length = 50, nullable = false)
    @NotBlank
    String name;

    @Column(length = 200, nullable = true)
    @Email
    String mail;

    @Column(nullable = true)
    @Min(0)
    @Max(150)
    int age;

    @Column(nullable = true)
    String memo;
}
