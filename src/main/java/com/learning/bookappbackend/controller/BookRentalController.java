package com.learning.bookappbackend.controller;

import com.learning.bookappbackend.dto.BookRentalDTO;
import com.learning.bookappbackend.dto.BookRentalDetailsDTO;
import com.learning.bookappbackend.model.BookRental;
import com.learning.bookappbackend.service.BookRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book-rental")
@RestController
@RequiredArgsConstructor
public class BookRentalController {

    private final BookRentalService bookRentalService;

    @GetMapping()
    public List<BookRental> getAll() {
        return bookRentalService.getAll();
    }

    @GetMapping("/active")
    public List<BookRentalDetailsDTO> getAllActive() {
        return bookRentalService.getAllActive();
    }

    @PostMapping
    public BookRentalDTO rentBook(@RequestBody BookRentalDTO bookRentalDTO) throws Exception {
       return bookRentalService.rentBook(bookRentalDTO);
    }
}
