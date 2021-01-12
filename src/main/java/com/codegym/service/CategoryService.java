package com.codegym.service;

import com.codegym.model.Category;


public interface CategoryService {

    Iterable<Category> findAll();

    Category findById(long id);

    void save(Category category);

    void remove(long id);
}
