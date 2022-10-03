package com.learning.bookappbackend.service;

import com.learning.bookappbackend.dto.AddBookRequestDTO;
import com.learning.bookappbackend.model.Book;
import com.learning.bookappbackend.model.BookDetails;
import com.learning.bookappbackend.model.User;
import com.learning.bookappbackend.repo.BookDetailsRepo;
import com.learning.bookappbackend.repo.BookRepo;
import com.learning.bookappbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final BookDetailService bookDetailService;
    private final BookDetailsRepo bookDetailsRepo;
    private final UserRepo userRepo;

    @Transactional
    public Book addBook(AddBookRequestDTO requestDTO) {
        Optional<BookDetails> bookDetails = bookDetailsRepo
                .findBookDetailsByTitleAndAuthorAndPublishingHouse(
                        requestDTO.getTitle(),
                        requestDTO.getAuthor(),
                        requestDTO.getPublishingHouse());
        Book newBook = new Book();
        User user = userRepo.findById(requestDTO.getOwnerId()).orElse(null);

        if(bookDetails.isPresent()) {
            newBook.setBookDetails(bookDetails.get());
            newBook.setIsAvailable(true);
            newBook.setOwner(user);

            return bookRepo.save(newBook);
        }

        BookDetails newBookDetails = new BookDetails(requestDTO.getTitle(), requestDTO.getAuthor(), requestDTO.getPublishingHouse());
        BookDetails updatedBookDetails = bookDetailsRepo.save(newBookDetails);
        newBook.setBookDetails(updatedBookDetails);
        newBook.setIsAvailable(true);
        newBook.setOwner(user);

        return bookRepo.save(newBook);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

}
