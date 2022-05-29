package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Author;
import com.bookstore.bookstore.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private BookService bookService;

    private AuthorServiceImpl authorService;

    @BeforeEach
    public void setUp(){

        authorService = new AuthorServiceImpl(authorRepository,bookService);
    }

    @Test
    public void verifyFindAll() {
        authorService.findAll();
        Mockito.verify(authorRepository, Mockito.times(1 )).findAll();
    }
    @Test
    public void verifySave() {
        Author expected = Author.builder()
                .id(1L)
                .name("Petyr")
                .build();

        Mockito.when(authorRepository.save(any(Author.class)))
                .thenReturn(Author.builder().id(1L).name("Petyr").build());



        Author actual = authorService.save(expected);

        Mockito.verify(authorRepository,Mockito.times(1)).save(expected);
        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(),actual.getName());


    }
    @Test
    public void verifyFindAllByName() {

        Mockito.when(authorRepository.findAllByName(any(String.class)))
                .thenReturn(Collections.singletonList(Author.builder().build()));

        List<Author> actual = authorService.findAllByName("");
        Mockito.verify(authorRepository, Mockito.times(1))
                .findAllByName(any(String.class));



    }


}