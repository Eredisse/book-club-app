package com.learning.bookappbackend.repo;

import com.learning.bookappbackend.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRentalRepo extends JpaRepository<BookRental, Long> {

    List<BookRental> findAllByBookIdAndActualReturnTimeIsNull(Long bookId);
}
