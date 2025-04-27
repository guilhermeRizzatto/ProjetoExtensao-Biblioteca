package com.rizzatto.biblioteca.model.dto;

import com.rizzatto.biblioteca.model.Cliente;
import com.rizzatto.biblioteca.model.Livro;

public record DadosSelect(Long id, String name) {

    public DadosSelect(Cliente cliente){
        this(cliente.getId(), cliente.getNome());
    }

    public DadosSelect(Livro livro){
        this(livro.getId(), livro.getTitulo());
    }
}
