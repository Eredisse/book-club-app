package com.learning.bookappbackend.repo;

import com.learning.bookappbackend.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRentalRepo extends JpaRepository<BookRental, Long> {

    List<BookRental> findAllByBook_idAndActualReturnTimeIsNull(Long bookId);
}
