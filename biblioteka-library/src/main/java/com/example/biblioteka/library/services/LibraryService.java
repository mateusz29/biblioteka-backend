package com.example.biblioteka.library.services;

import com.example.biblioteka.library.entities.Library;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibraryService {
    List<Library> findAllLibraries();
    void saveLibrary(Library library);
    Optional<Library> findLibraryById(UUID uuid);
    void deleteLibraryById(UUID uuid);
    void updateLibraryById(UUID uuid, Library library);
}
