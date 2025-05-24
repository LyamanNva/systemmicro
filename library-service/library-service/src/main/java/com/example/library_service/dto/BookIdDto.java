package com.example.library_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookIdDto {

    private String bookId;
    private String isbn;

    public static BookIdDto convert(String id, String isbn) {
        return new BookIdDto(id, isbn);
    }
}
