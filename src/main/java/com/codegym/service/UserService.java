package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(long id);

    void save(User user);

    void remove(long id);
    User findByUserName(String userName);
}
