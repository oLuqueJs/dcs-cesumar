package com.crud.demo.book;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "TBL_BOOK")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private BookEnum bookEnum;

    public BookModel(String nome, String categoria, BookEnum bookEnum ){
        this.nome = nome;
        this.categoria = categoria;
        this.bookEnum = bookEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BookEnum getBookEnum() {
        return  this.bookEnum;
    }

    public void setBookEnum(BookEnum bookenum) {
        this.bookEnum = bookenum;
    }
}
