package com.learning.bookappbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.print.Book;

@Table(name = "book_details")
@Entity
@Data
@NoArgsConstructor
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String publishingHouse;

    public BookDetails(String title, String author, String publishingHouse) {
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }
}
