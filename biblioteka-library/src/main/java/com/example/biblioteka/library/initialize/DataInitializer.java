package com.example.biblioteka.library.initialize;

import com.example.biblioteka.library.entities.Library;
import com.example.biblioteka.library.services.LibraryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer{
    private final LibraryService libraryService;

    public DataInitializer(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostConstruct
    public void initializeData(){
        Library library1 = Library.builder().id(UUID.fromString("fb787021-cc4f-4233-88f4-dd3104e3e572")).name("Small library").yearFounded(1950).build();
        libraryService.saveLibrary(library1);
        Library library2 = Library.builder().id(UUID.fromString("1cefcdc1-37f3-40d2-ad6a-40e9c2e241f3")).name("Big library").yearFounded(1984).build();
        libraryService.saveLibrary(library2);
    }
}
