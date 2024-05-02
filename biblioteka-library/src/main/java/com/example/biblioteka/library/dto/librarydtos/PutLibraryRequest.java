package com.example.biblioteka.library.dto.librarydtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutLibraryRequest {
    private String name;
    private int yearFounded;
}