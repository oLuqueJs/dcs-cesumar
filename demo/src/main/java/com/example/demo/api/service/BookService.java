package com.example.demo.api.service;

import com.example.demo.api.model.Book;
import com.example.demo.api.model.Genre;
import com.example.demo.api.model.BookStatus;
import com.example.demo.api.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findBooksByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> findBooksByStatus(BookStatus status) {
        return bookRepository.findByStatus(status);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBookStatus(Long id, BookStatus status) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        book.setStatus(status);
        return bookRepository.save(book);
    }
}