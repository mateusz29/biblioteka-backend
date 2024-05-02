package com.example.biblioteka.library.event.repository;

import com.example.biblioteka.library.entities.Library;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class LibraryEventRestRepository implements LibraryEventRepository{

    private final RestTemplate restTemplate;

    @Autowired
    public LibraryEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID uuid) {
        restTemplate.delete("/api/libraries/{libraryId}", uuid);
    }

    @Override
    public void create(UUID uuid) {
        Library library = Library.builder().build();
        restTemplate.put("/api/libraries/{libraryId}",library, uuid);
    }

}

