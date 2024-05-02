package com.example.biblioteka.library.repository;

import com.example.biblioteka.library.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends JpaRepository<Library, UUID> {
}
