package com.example.biblioteka.library.mappers;

import com.example.biblioteka.library.dto.LibraryDto;
import com.example.biblioteka.library.dto.librarydtos.GetLibraryResponse;
import com.example.biblioteka.library.dto.librarydtos.PutLibraryRequest;
import com.example.biblioteka.library.entities.Library;
import org.mapstruct.Mapper;

@Mapper
public interface LibraryMapper {

    Library libraryDtotoLibrary(LibraryDto libraryDto);

    LibraryDto libraryToLibraryDto(Library library);

    GetLibraryResponse libraryToGetLibraryResponse(Library library);

    Library putLibraryRequestToLibrary(PutLibraryRequest putLibraryRequest);
}
