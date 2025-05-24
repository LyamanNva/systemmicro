package com.example.library_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibraryDto {

    private String id;
    private List<BookDto> userBookList=new ArrayList<>();

    public LibraryDto(String id) {
        this.id = id;
    }
}
