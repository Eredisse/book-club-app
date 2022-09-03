package com.learning.bookappbackend.repo;

import com.learning.bookappbackend.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDetailsRepo extends JpaRepository<BookDetails, Long> {

    Optional<BookDetails> findBookDetailsByTitleAndAuthorAndPublishingHouse(String title, String author, String publishingHouse);
}
