package com.example.biblioteka.library.dto.librarydtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetLibraryResponse {
    private UUID id;
    private String name;
    private int yearFounded;
}
