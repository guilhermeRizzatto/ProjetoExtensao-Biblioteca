package com.rizzatto.biblioteca.controller;

import com.rizzatto.biblioteca.model.dto.DadosNovaSenha;
import com.rizzatto.biblioteca.model.dto.DadosUsuario;
import com.rizzatto.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody DadosUsuario usuario) {
        service.login(usuario);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/updateSenha")
    public ResponseEntity<?> updateSenha(@RequestBody DadosNovaSenha dados) {
        service.update(dados);
        return ResponseEntity.ok().build();
    }

}
