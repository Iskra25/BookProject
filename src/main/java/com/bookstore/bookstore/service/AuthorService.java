package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {

    Author save(Author author);

    Author findById(Long id);

    List<Author> findAll();

    List <Author> findAllByName(String name);
}
