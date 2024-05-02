package com.example.biblioteka.book.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookDto {
    private UUID id;
    private int yearPublished;
    private String title;
    private String author;
    private UUID library;
}