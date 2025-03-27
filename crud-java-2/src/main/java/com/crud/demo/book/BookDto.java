package com.crud.demo.book;

public class BookDto {
    public String setCategoria;
    private Long id;
    private String nome;
    private String categoria;
    private BookEnum bookEnum;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public BookEnum getBookEnum() {
        return bookEnum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setBookEnum(BookEnum bookEnum) {
        this.bookEnum = bookEnum;
    }
}
