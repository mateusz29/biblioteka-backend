package com.example.biblioteka.book.controller;

import com.example.biblioteka.book.dto.bookdtos.GetBookResponse;
import com.example.biblioteka.book.dto.bookdtos.GetBooksResponse;
import com.example.biblioteka.book.dto.bookdtos.PutBookRequest;
import com.example.biblioteka.book.mappers.BookMapper;
import com.example.biblioteka.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class BookController {
    public final String BOOK_PATH = "api/books";
    public final String BOOK_PATH_ID = BOOK_PATH + "/{bookId}";
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/api/libraries/{libraryId}/books")
    public ResponseEntity<GetBooksResponse> getBooksFromLibrary(@PathVariable("libraryId") UUID uuid) {
        return ResponseEntity.ok(GetBooksResponse.builder().books(bookService.findBooksByLibraryId(uuid).stream().map(bookMapper::bookToBookDto).toList()).build());
    }

    @GetMapping(BOOK_PATH)
    public ResponseEntity<GetBooksResponse> getBooks() {
        return ResponseEntity.ok(GetBooksResponse.builder().books(bookService.getAllBooks().stream().map(bookMapper::bookToBookDto).toList()).build());
    }

    @GetMapping(BOOK_PATH_ID)
    public ResponseEntity<GetBookResponse> getBook(@PathVariable("bookId") UUID uuid){
        return ResponseEntity.ok(bookService.findBookById(uuid).map(bookMapper::bookToGetBookResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PutMapping(BOOK_PATH_ID)
    public ResponseEntity<Void> putBook(@PathVariable("bookId") UUID uuid, @RequestBody PutBookRequest putBookRequest){
        bookService.saveBook(bookMapper.putBookRequestToBook(uuid, putBookRequest));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(BOOK_PATH_ID)
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") UUID uuid){
        bookService.findBookById(uuid).ifPresentOrElse(book -> bookService.deleteBookById(uuid),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
        return ResponseEntity.noContent().build();
    }
}
