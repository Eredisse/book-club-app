package com.learning.bookappbackend.mapper;

import com.learning.bookappbackend.dto.BookRentalDTO;
import com.learning.bookappbackend.model.BookRental;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BookRentalMapper {

    BookRentalDTO bookRentalEntityToBookRentalDTO(BookRental bookRental);
    BookRental bookRentalDTOToBookRentalEntity(BookRentalDTO bookRentalDTO);
}
