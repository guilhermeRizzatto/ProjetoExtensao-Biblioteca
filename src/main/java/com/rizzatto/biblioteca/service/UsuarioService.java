package com.rizzatto.biblioteca.service;

import com.rizzatto.biblioteca.exception.ValidacaoException;
import com.rizzatto.biblioteca.model.Usuario;
import com.rizzatto.biblioteca.model.dto.DadosNovaSenha;
import com.rizzatto.biblioteca.model.dto.DadosUsuario;
import com.rizzatto.biblioteca.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public boolean login(DadosUsuario usuario){

        Usuario usr = repository.findByIdentificao(usuario.identificacao());

        if(usr != null){
            if(usr.getSenha().equals(usuario.senha())){;
                return true;
            }
            throw new ValidacaoException("Senha incorreta");
        }
        return false;
    }

    public void update(DadosNovaSenha dados){

        Usuario usuario = repository.findByIdentificao(dados.identificacao());

        if(dados.senhaOld().equals(usuario.getSenha())){
            usuario.setSenha(dados.senhaNew());
            repository.save(usuario);
        }
        throw new ValidacaoException("Senha incorreta");
    }

}
