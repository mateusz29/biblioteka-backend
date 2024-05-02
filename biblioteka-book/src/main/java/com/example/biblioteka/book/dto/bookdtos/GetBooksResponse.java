package com.example.biblioteka.book.dto.bookdtos;

import com.example.biblioteka.book.dto.BookDto;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class GetBooksResponse {
    @Singular
    private List<BookDto> books;
}
