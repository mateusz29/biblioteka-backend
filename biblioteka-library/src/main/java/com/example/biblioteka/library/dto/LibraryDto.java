package com.example.biblioteka.library.dto;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class LibraryDto {
    private UUID id;
    private String name;
    private int yearFounded;
}