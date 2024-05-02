package com.example.biblioteka.library.event.repository;

import java.util.UUID;

public interface LibraryEventRepository {
    void delete(UUID uuid);
    void create(UUID uuid);

}




