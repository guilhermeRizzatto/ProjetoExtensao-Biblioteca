package com.rizzatto.biblioteca.model.repository;

import com.rizzatto.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByidentificacao(String identificacao);
}
