package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Author;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final BookService bookService;

    public AuthorServiceImpl(final AuthorRepository authorRepository,
                             final BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }


    @Override
    public Author save(Author author) {
        Set<Book> books =author.getBooks();
        for (Book book :books) {
            bookService.save(book);

        }

        return authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(RuntimeException:: new);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> findAllByName(String name) {
        return authorRepository.findAllByName(name);
    }
}
