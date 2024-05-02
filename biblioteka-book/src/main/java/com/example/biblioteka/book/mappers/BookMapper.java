package com.example.biblioteka.book.mappers;


import com.example.biblioteka.book.dto.BookDto;
import com.example.biblioteka.book.dto.bookdtos.GetBookResponse;
import com.example.biblioteka.book.entities.Book;
import com.example.biblioteka.library.entities.Library;
import com.example.biblioteka.book.dto.bookdtos.PutBookRequest;


import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface BookMapper {
    default BookDto bookToBookDto(Book book) {
        if (book == null){
            return null;
        }
        return BookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle())
                .yearPublished(book.getYearPublished())
                .library(book.getLibrary().getId())
                .build();
    }
    default GetBookResponse bookToGetBookResponse(Book book) {
        if (book == null){
            return null;
        }
        return GetBookResponse.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle())
                .yearPublished(book.getYearPublished())
                .library(book.getLibrary().getId())
                .build();
    }
    default Book putBookRequestToBook(UUID uuid, PutBookRequest putBookRequest){
        if(putBookRequest == null){
            return null;
        }

        return Book.builder()
                .id(uuid)
                .author(putBookRequest.getAuthor())
                .title(putBookRequest.getTitle())
                .yearPublished(putBookRequest.getYearPublished())
                .library(Library.builder()
                        .id(putBookRequest.getLibrary())
                        .build())
                .build();
    }
}
