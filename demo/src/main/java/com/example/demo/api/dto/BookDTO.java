package com.example.demo.api.dto;

import com.example.demo.api.model.Genre;
import com.example.demo.api.model.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishDate;
    private Genre genre;
    private BookStatus status;
}