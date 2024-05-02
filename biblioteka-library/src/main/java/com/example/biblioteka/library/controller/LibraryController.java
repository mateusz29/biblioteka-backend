package com.example.biblioteka.library.controller;

import com.example.biblioteka.library.dto.librarydtos.GetLibrariesResponse;
import com.example.biblioteka.library.dto.librarydtos.GetLibraryResponse;
import com.example.biblioteka.library.dto.librarydtos.PutLibraryRequest;
import com.example.biblioteka.library.mappers.LibraryMapper;
import com.example.biblioteka.library.services.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequestMapping("/api/libraries")
@RestController
public class LibraryController {
    private final LibraryService libraryService;
    private final LibraryMapper libraryMapper;


    public LibraryController(LibraryService libraryService, LibraryMapper libraryMapper) {
        this.libraryService = libraryService;
        this.libraryMapper = libraryMapper;
    }

    @GetMapping()
    public ResponseEntity<GetLibrariesResponse> getLibraries(){
        return ResponseEntity.ok(GetLibrariesResponse.builder().libraries(libraryService.findAllLibraries().stream().map(libraryMapper::libraryToLibraryDto).toList()).build());
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<GetLibraryResponse> getLibrary(@PathVariable("libraryId") UUID uuid){
        return ResponseEntity.ok(libraryService.findLibraryById(uuid).map(libraryMapper::libraryToGetLibraryResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PutMapping("/{libraryId}")
    public ResponseEntity<Void> putLibrary(@PathVariable("libraryId") UUID uuid, @RequestBody PutLibraryRequest putLibraryRequest){
        libraryService.updateLibraryById(uuid, libraryMapper.putLibraryRequestToLibrary(putLibraryRequest));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable("libraryId") UUID uuid){
        libraryService.findLibraryById(uuid).ifPresentOrElse(library -> libraryService.deleteLibraryById(uuid),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
        return ResponseEntity.noContent().build();
    }
}
