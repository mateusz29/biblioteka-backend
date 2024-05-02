package com.example.biblioteka.book.service;

import com.example.biblioteka.book.entities.Book;
import com.example.biblioteka.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookDefaultService implements BookService {
    private final BookRepository bookRepository;

    public BookDefaultService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findBookById(UUID uuid){
        return bookRepository.findById(uuid);
    }
    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    @Override
    public void saveBook(Book book){
        bookRepository.save(book);
    }
    @Override
    public void deleteBookById(UUID uuid){
        bookRepository.deleteById(uuid);
    }
    @Override
    public List<Book> findBooksByLibraryId(UUID uuid){
        return bookRepository.findByLibraryId(uuid);
    }
}
