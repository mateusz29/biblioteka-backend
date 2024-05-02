package com.example.biblioteka.library.dto.librarydtos;

import com.example.biblioteka.library.dto.LibraryDto;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class GetLibrariesResponse {
    private List<LibraryDto> libraries;
}
