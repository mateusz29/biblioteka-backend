package com.example.biblioteka.library.controller;

import com.example.biblioteka.library.entities.Library;
import com.example.biblioteka.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @DeleteMapping("/api/libraries/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable("libraryId") UUID uuid) {
        libraryService.delete(uuid);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/api/libraries/{libraryId}")
    public ResponseEntity<Void> putLibrary(@PathVariable("libraryId") UUID uuid) {
        Library library = Library.builder().id(uuid).build();
        libraryService.create(library);
        return ResponseEntity.accepted().build();
    }
}