package com.rizzatto.biblioteca.model.dto;

import com.rizzatto.biblioteca.model.Usuario;

public record DadosUsuario(String identificacao, String senha) {

    public DadosUsuario(Usuario usuario) {
        this(usuario.getIdentificacao(), usuario.getSenha());
    }
}
