package com.example.biblioteka.library.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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

    @Column(unique = true)
    private String name;

    @Column(name = "year_founded")
    private int yearFounded;
}
