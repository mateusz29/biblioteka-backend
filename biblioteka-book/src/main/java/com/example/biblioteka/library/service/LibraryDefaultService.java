package com.example.biblioteka.library.service;

import com.example.biblioteka.library.entities.Library;
import com.example.biblioteka.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Optional;

@Service
public class LibraryDefaultService implements LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryDefaultService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Optional<Library> find(UUID id) {
        return libraryRepository.findById(id);
    }

    @Override
    public void create(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public void delete(UUID id) {
        libraryRepository.findById(id).ifPresent(libraryRepository::delete);
    }

}
