package com.example.library_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {

    private BookIdDto id;
    private String title;
    private Integer year;
    private String author;
    private String pressName;
}
