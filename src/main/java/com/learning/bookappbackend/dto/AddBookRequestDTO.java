package com.learning.bookappbackend.dto;

import lombok.Data;

@Data
public class AddBookRequestDTO {
    private String title;
    private String author;
    private String publishingHouse;
    private Long ownerId;
}
