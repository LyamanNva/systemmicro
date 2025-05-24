package com.example.library_service.service;

import com.example.library_service.client.BookServiceClient;
import com.example.library_service.dto.AddBookRequest;
import com.example.library_service.dto.LibraryDto;
import com.example.library_service.exception.LibraryNotFoundException;
import com.example.library_service.model.Library;
import com.example.library_service.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryDto getAllBooksInLibraryById(String id){
        Library library =libraryRepository.findById(id)
                .orElseThrow(()->new LibraryNotFoundException("Library couldnt found by id:"+id));

        LibraryDto libraryDto=new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList()));
        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library newLibrary=libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId());
    }

    public void addBookToLibrary(AddBookRequest request){
        String bookId=bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();

        Library library=libraryRepository.findById(request.getId())
                .orElseThrow(()->new LibraryNotFoundException("Library couldnt found by id:"+request.getId()));

        library.getUserBook()
                .add(bookId);
        libraryRepository.save(library);
    }
}
