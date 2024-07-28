package com.example.demo;

import java.io.Serializable;
import java.util.List;

public interface PersonDao <T> extends Serializable{

    public List<T> getAll();

    public T findById(Integer id);
    public List<T> findByName(String name);
}
