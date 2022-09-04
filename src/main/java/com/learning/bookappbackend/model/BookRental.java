package com.learning.bookappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="book_rental")
@Entity
@Getter
@Setter
public class BookRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private Long book_id;

    private LocalDate rentalTime;

    private LocalDate expectedReturnTime;

    private LocalDate actualReturnTime;
}
