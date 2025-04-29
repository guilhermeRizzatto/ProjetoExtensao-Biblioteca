package com.rizzatto.biblioteca.controller;

import com.rizzatto.biblioteca.model.dto.DadosNovaSenha;
import com.rizzatto.biblioteca.model.dto.DadosUsuario;
import com.rizzatto.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping()
    public ResponseEntity<?> login(@RequestBody DadosUsuario usuario) {
        if(service.login(usuario)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody DadosNovaSenha dados) {
        service.update(dados);
        return ResponseEntity.ok().build();
    }

}
