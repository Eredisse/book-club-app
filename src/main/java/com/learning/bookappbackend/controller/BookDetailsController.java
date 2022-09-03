package com.learning.bookappbackend.controller;

import com.learning.bookappbackend.model.BookDetails;
import com.learning.bookappbackend.service.BookDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book-details")
@RequiredArgsConstructor
public class BookDetailsController {

    private final BookDetailService bookDetailService;

    @GetMapping()
    public List<BookDetails> getAllBooks() {
        return bookDetailService.getAllBookDetails();
    }

    @PostMapping()
    public BookDetails addBook(@RequestBody BookDetails bookDetails) {
        return bookDetailService.addBookDetails(bookDetails);
    }

}
