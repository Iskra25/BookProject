package com.bookstore.bookstore.converter;

import com.bookstore.bookstore.dto.AuthorRequest;
import com.bookstore.bookstore.entity.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AuthorConverter {
    private BookConverter bookConverter;

    public Author map(AuthorRequest authorRequest){
        return Author.builder()
                .name(authorRequest.getName())
                .books(authorRequest.getBookRequests().stream()
                        .map(bookRequest -> bookConverter.map(bookRequest))
                        .collect(Collectors.toSet()))
                .build();
    }
}