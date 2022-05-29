package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.converter.AuthorConverter;
import com.bookstore.bookstore.dto.AuthorRequest;
import com.bookstore.bookstore.dto.AuthorResponse;
import com.bookstore.bookstore.entity.Author;
import com.bookstore.bookstore.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value= "/authors")

public class AuthorController {

    private final AuthorService authorService;
    private final AuthorConverter authorConverter;

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@RequestBody final AuthorRequest authorRequest) {
        final Author author = authorConverter.map(authorRequest);
        final Author saved = authorService.save(author);

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> findById(@PathVariable Long id) {
        Author author = authorService.findById(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
