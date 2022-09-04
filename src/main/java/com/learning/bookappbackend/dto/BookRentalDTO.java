package com.learning.bookappbackend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRentalDTO {
    private Long userId;
    private Long bookId;
    private LocalDate rentalTime;
    private LocalDate expectedReturnTime;
}
