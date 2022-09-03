package com.learning.bookappbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BookDetails bookDetails;

    @OneToOne
    private User owner;

    private Boolean isAvailable;

    @OneToOne
    private User rentedTo;
}
