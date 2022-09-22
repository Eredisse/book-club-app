package com.learning.bookappbackend.service;

import com.learning.bookappbackend.dto.BookRentalDTO;
import com.learning.bookappbackend.dto.BookRentalDetailsDTO;
import com.learning.bookappbackend.mapper.BookRentalMapper;
import com.learning.bookappbackend.model.Book;
import com.learning.bookappbackend.model.BookRental;
import com.learning.bookappbackend.model.User;
import com.learning.bookappbackend.repo.BookDetailsRepo;
import com.learning.bookappbackend.repo.BookRentalRepo;
import com.learning.bookappbackend.repo.BookRepo;
import com.learning.bookappbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookRentalService {

    private final BookRentalRepo bookRentalRepo;
    private final BookRepo bookRepo;
    private final BookRentalMapper bookRentalMapper;
    private final UserRepo userRepo;
    private final BookDetailsRepo bookDetailsRepo;

    @Transactional
    public BookRentalDTO rentBook(BookRentalDTO bookRentalDTO) throws Exception {

        Book book = bookRepo.findById(bookRentalDTO.getBookId()).orElseThrow(
                () -> new Exception("Cartea nu există!"));
        List <BookRental> activeRentals = bookRentalRepo
                .findAllByBookIdAndActualReturnTimeIsNull(book.getId());
        User user = userRepo.findById(bookRentalDTO.getUserId()).orElseThrow(
                () -> new Exception("Userul nu exista!"));

        if(!book.getIsAvailable() || !CollectionUtils.isEmpty(activeRentals)) {
            throw new Exception("Cartea este deja împrumutată!");
        }

        book.setIsAvailable(false);
        book.setRentedTo(user);
        bookRepo.save(book);
        bookRentalRepo.save(bookRentalMapper.bookRentalDTOToBookRentalEntity(bookRentalDTO));
        return bookRentalDTO;
    }

    public List<BookRental> getAll() {
        return bookRentalRepo.findAll();
    }

    public List<BookRentalDetailsDTO> getAllActive() {
        List<BookRental> bookRentals = bookRentalRepo.findAll();
        return bookRentals.stream()
                .map(rental -> new BookRentalDetailsDTO(
                                rental,
                                bookDetailsRepo.findById(rental.getBookId()).get())
                ).collect(Collectors.toList());
    }



}
