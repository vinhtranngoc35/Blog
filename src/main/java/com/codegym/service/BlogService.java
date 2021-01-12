package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findOne(Long id);

    Blog save(Blog blog);

    void delete(Long id);

    void remove(Long id);

    Iterable<Blog> findAll(long id);

    Page<Blog> findAllByNameContaining(String firstname, Pageable pageable);

    Page<Blog> findAllByCategoryId(long id,Pageable pageable);

    Page<Blog> findAllByNameLike(String name,Pageable pageable);
}