package com.example.biblioteka.book.service;

import com.example.biblioteka.book.entities.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Optional<Book> findBookById(UUID uuid);
    void deleteBookById(UUID uuid);
    List<Book> findBooksByLibraryId(UUID uuid);
}
