package com.example.biblioteka.book.initialize;

import com.example.biblioteka.book.entities.Book;
import com.example.biblioteka.book.service.BookService;
import com.example.biblioteka.library.entities.Library;
import com.example.biblioteka.library.service.LibraryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final LibraryService libraryService;
    public DataInitializer(BookService bookService, LibraryService libraryService) {
        this.bookService = bookService;
        this.libraryService = libraryService;
    }

    @PostConstruct
    public void initializeData(){

        Library library1 = Library.builder().id(UUID.fromString("fb787021-cc4f-4233-88f4-dd3104e3e572")).build();
        libraryService.create(library1);
        Library library2 = Library.builder().id(UUID.fromString("1cefcdc1-37f3-40d2-ad6a-40e9c2e241f3")).build();
        libraryService.create(library2);

        Book book = Book.builder().id(UUID.fromString("a6ccc152-f08f-45e2-9781-a9d974b1cd93")).title("Shadows in Silence").author("Eva Lee").yearPublished(1925).library(library1).build();
        bookService.saveBook(book);
        Book book1 = Book.builder().id(UUID.fromString("37f1266e-3c91-4739-a149-5cd84b357eab")).title("Midnight Reverie").author("Alex Quinn").yearPublished(2016).library(library2).build();
        bookService.saveBook(book1);
        Book book2 = Book.builder().id(UUID.fromString("d20e566b-38df-44db-99f8-32926e0a61bd")).title("Fading Memories").author("Liam Ross").yearPublished(1983).library(library1).build();
        bookService.saveBook(book2);
        Book book3 = Book.builder().id(UUID.fromString("26778f06-f488-4336-b433-16ff474352b4")).title("Spectral Whispers").author("Max Hayes").yearPublished(1945).library(library1).build();
        bookService.saveBook(book3);
        Book book4 = Book.builder().id(UUID.fromString("25463a0a-0c98-4a19-b456-54f29f1f786e")).title("Crimson Horizon").author("Nina King").yearPublished(1897).library(library2).build();
        bookService.saveBook(book4);
        Book book5 = Book.builder().id(UUID.fromString("87b8f545-4403-464f-8612-0d36067e49b4")).title("Ephemeral Veil").author("Sara Fox").yearPublished(2004).library(library2).build();
        bookService.saveBook(book5);
        Book book6 = Book.builder().id(UUID.fromString("4f93ae49-fd79-4872-a315-2f2aa85a0ee9")).title("Forgotten Fables").author("Jude Lane").yearPublished(1965).library(library1).build();
        bookService.saveBook(book6);
    }
}
