package com.rizzatto.biblioteca.controller;

import com.rizzatto.biblioteca.model.Livro;
import com.rizzatto.biblioteca.model.dto.DadosLivro;
import com.rizzatto.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping()
    public ResponseEntity<Page<Livro>> getLivros(@RequestParam int pageNumber,
                                                 @RequestParam int pageSize) {
        Page<Livro> livros = service.getLivros(pageNumber,pageSize);
        return ResponseEntity.ok(livros);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Livro> getLivroByID(@PathVariable Long id) {
        Livro livro = service.getLivroID(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping()
    public ResponseEntity<Livro> save(@RequestBody DadosLivro dados) {
        Livro livro = service.add(dados);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri()).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
