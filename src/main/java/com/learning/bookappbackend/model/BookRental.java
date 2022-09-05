package com.learning.bookappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="book_rental")
@Entity
@Getter
@Setter
public class BookRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long bookId;

    private LocalDateTime rentalTime;

    private LocalDateTime expectedReturnTime;

    private LocalDateTime actualReturnTime;
}
