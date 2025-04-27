package com.rizzatto.biblioteca.model.dto;

import com.rizzatto.biblioteca.model.Livro;

public record DadosLivro(Long id, String titulo, String ano, String status) {

    public DadosLivro(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAno(), livro.getStatus().toString());
    }
}
