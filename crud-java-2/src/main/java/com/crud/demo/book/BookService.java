package com.crud.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BookDto criarLivro(BookDto bookDto) {
        BookModel bookModel = convertToModel(bookDto);
        BookModel savedBook = bookRepository.save(bookModel);
        return convertToDto(savedBook);
    }

    public void deletarLivro(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDto convertToDto(BookModel bookModel) {
        BookDto bookDto = new BookDto();
        bookDto.setNome(bookModel.getNome());
        bookDto.setCategoria = bookModel.getCategoria();
        bookDto.setBookEnum(bookModel.getBookEnum());
        return bookDto;
    }

    private BookModel convertToModel(BookDto bookDto) {
        return new BookModel(
                bookDto.getNome(),
                bookDto.getCategoria(),
                bookDto.getBookEnum()
        );
    }
}