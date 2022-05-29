package com.bookstore.bookstore.entity;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Entity
@Table(name="author_books")
public class AuthorsBooks {

    @Column(name= "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name="author_id")
    private Author authorId;

    @OneToOne
    @JoinColumn(name="book_id")
    private Book bookId;


}
