package com.example.biblioteka.book.dto.bookdtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PutBookRequest {
    private int yearPublished;
    private String title;
    private String author;
    private UUID library;
}
