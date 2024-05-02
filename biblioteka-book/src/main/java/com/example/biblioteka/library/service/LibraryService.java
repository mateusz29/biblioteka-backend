package com.example.biblioteka.library.service;

import com.example.biblioteka.library.entities.Library;

import java.util.Optional;
import java.util.UUID;

public interface LibraryService {
    Optional<Library> find (UUID uuid);
    void delete(UUID uuid);
    void create(Library library);
}
