package com.bookstore.bookstore.converter;

import com.bookstore.bookstore.dto.BookRequest;
import com.bookstore.bookstore.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public Book map(BookRequest bookRequest){
        return Book.builder()
                .Title(bookRequest.getTitle())
                .year(bookRequest.getYear())
                .build();
    }
}
