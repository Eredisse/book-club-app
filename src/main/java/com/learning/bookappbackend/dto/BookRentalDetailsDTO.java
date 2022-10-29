package com.learning.bookappbackend.dto;

import com.learning.bookappbackend.model.BookDetails;
import com.learning.bookappbackend.model.BookRental;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRentalDetailsDTO{

    BookRental bookRentalDTO;

    BookDetails bookDetails;
}
