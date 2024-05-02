package com.example.biblioteka.library.services;

import com.example.biblioteka.library.entities.Library;
import com.example.biblioteka.library.repositories.LibraryRepository;
import org.springframework.stereotype.Service;
import com.example.biblioteka.library.event.repository.LibraryEventRestRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LibraryDefaultService implements LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryEventRestRepository eventRepository;

    public LibraryDefaultService(LibraryRepository libraryRepository, LibraryEventRestRepository eventRepository) {
        this.libraryRepository = libraryRepository;
        this.eventRepository = eventRepository;
    }
    @Override
    public List<Library> findAllLibraries(){
        return libraryRepository.findAll();
    }
    @Override
    public void saveLibrary(Library library){
        libraryRepository.save(library);
    }
    @Override
    public Optional<Library> findLibraryById(UUID uuid){
        return libraryRepository.findById(uuid);
    }
    @Override
    public void deleteLibraryById(UUID uuid){
        libraryRepository.deleteById(uuid);
        eventRepository.delete(uuid);
    }
    @Override
    public void updateLibraryById(UUID uuid, Library library){
        library.setId(uuid);
        libraryRepository.save(library);
        eventRepository.create(uuid);
    }

}
