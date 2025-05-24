package com.example.book_service.service;

import com.example.book_service.dto.BookDto;
import com.example.book_service.dto.BookIdDto;
import com.example.book_service.exception.BookNotFoundException;
import com.example.book_service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookDto> getAllBooks(){
        return repository.findAll()
                .stream()
                .map(BookDto::convert)
                .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn){
        return repository.getBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(()->new BookNotFoundException("Book couldnt found by isbn:"+isbn));
    }
    public BookDto findBookDetailsById(String id){
        return repository.findById(id)
                .map(BookDto::convert)
                .orElseThrow(()->new BookNotFoundException("Book couldnt found by id: "+id));
    }
}
