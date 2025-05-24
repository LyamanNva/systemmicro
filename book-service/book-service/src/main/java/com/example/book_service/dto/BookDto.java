package com.example.book_service.dto;

import com.example.book_service.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private BookIdDto id;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;

    public static BookDto convert(Book from){
        BookIdDto id=null;
        if (from.getId()!=null){
            id=BookIdDto.convert(from.getId(),from.getIsbn());
        }
        return new BookDto(id,from.getTitle(),from.getBookYear(),from.getAuthor(),from.getPressName());
    }
}
