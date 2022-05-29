package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {

        return bookRepository.findAll();
    }
}
