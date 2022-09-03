package com.learning.bookappbackend.service;

import com.learning.bookappbackend.model.BookDetails;
import com.learning.bookappbackend.repo.BookDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDetailService {

    private final BookDetailsRepo bookDetailsRepo;

    public List<BookDetails> getAllBookDetails() {
        return bookDetailsRepo.findAll();
    }

    public BookDetails addBookDetails(BookDetails bookDetails) {
        return bookDetailsRepo.save(bookDetails);
    }

}
