package com.example.demo.api.repository;

import com.example.demo.api.model.Book;
import com.example.demo.api.model.Genre;
import com.example.demo.api.model.BookStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(Genre genre);

    List<Book> findByStatus(BookStatus status);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByTitleContainingIgnoreCase(String title);
}