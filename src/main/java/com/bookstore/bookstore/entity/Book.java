package com.bookstore.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="books",indexes = {
        @Index(name="idx_title", columnList = "title"),
        @Index(name= "idx_year", columnList= "year")
})
@Data
@Builder

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column( nullable = false)
    private String Title;

    @Column( nullable = false)
    private Integer year;



    @OneToMany(mappedBy = "books")
    private Set<Author> authors;



}