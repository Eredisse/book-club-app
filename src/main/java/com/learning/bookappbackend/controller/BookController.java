package com.learning.bookappbackend.controller;

import com.learning.bookappbackend.dto.AddBookRequestDTO;
import com.learning.bookappbackend.model.Book;
import com.learning.bookappbackend.model.BookDetails;
import com.learning.bookappbackend.repo.BookDetailsRepo;
import com.learning.bookappbackend.service.BookDetailService;
import com.learning.bookappbackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

//    private final BookService bookService;
//
//    @PostMapping()
//    private Book addBook(@RequestBody AddBookRequestDTO requestDTO) {
//        return bookService.addBook(requestDTO);
//    }

}
