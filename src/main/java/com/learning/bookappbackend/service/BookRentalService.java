package com.learning.bookappbackend.service;

import com.learning.bookappbackend.dto.BookRentalDTO;
import com.learning.bookappbackend.mapper.BookRentalMapper;
import com.learning.bookappbackend.model.Book;
import com.learning.bookappbackend.model.BookRental;
import com.learning.bookappbackend.repo.BookRentalRepo;
import com.learning.bookappbackend.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRentalService {

    private final BookRentalRepo bookRentalRepo;
    private final BookRepo bookRepo;
    private final BookRentalMapper bookRentalMapper;

    @Transactional
    public BookRentalDTO rentBook(BookRentalDTO bookRentalDTO) throws Exception {

        Book book = bookRepo.findById(bookRentalDTO.getBookId()).orElseThrow(
                () -> new Exception("Cartea nu există!"));
        List <BookRental> activeRentals = bookRentalRepo
                .findAllByBook_idAndActualReturnTimeIsNull(book.getId());

        if(!book.getIsAvailable() || activeRentals != null || activeRentals.isEmpty()) {
            throw new Exception("Cartea este deja împrumutată!");
        }

        book.setIsAvailable(false);
        bookRepo.save(book);
        bookRentalRepo.save(bookRentalMapper.bookRentalDTOToBookRentalEntity(bookRentalDTO));
        return bookRentalDTO;
    }

    public List<BookRental> getAll() {
        return bookRentalRepo.findAll();
    }



}
