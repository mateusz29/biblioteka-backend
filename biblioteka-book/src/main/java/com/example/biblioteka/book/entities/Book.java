package com.example.biblioteka.book.entities;

import com.example.biblioteka.library.entities.Library;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@EqualsAndHashCode(exclude = "library")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @Column(name = "bookId")
    private UUID id;

    @Column(name = "year_published")
    private int yearPublished;

    @Column(unique = true)
    private String title;

    @Column(name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "library")
    private Library library;
}
