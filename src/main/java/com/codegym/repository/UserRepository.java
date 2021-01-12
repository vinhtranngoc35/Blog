package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    public User findByUsername(String username);
}
