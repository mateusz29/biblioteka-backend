package com.example.biblioteka.library.entities;

import com.example.biblioteka.book.entities.Book;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "libraries")
public class Library implements Serializable {
    @Id
    @Column(name = "libraryId")
    private UUID id;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books;
}
