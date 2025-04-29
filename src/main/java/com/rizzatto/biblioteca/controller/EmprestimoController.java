package com.rizzatto.biblioteca.controller;

import com.rizzatto.biblioteca.model.Emprestimo;
import com.rizzatto.biblioteca.model.dto.DadosEmprestimo;
import com.rizzatto.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping()
    public ResponseEntity<Page<Emprestimo>> getEmprestimos(@RequestParam int pageNumber,
                                                           @RequestParam int pageSize) {
        Page<Emprestimo> emprestimos = service.getEmprestimos(pageNumber,pageSize);
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Emprestimo> getEmprestimoByID(@PathVariable Long id) {
        Emprestimo emprestimo = service.getEmprestimoID(id);
        return ResponseEntity.ok(emprestimo);
    }

    @PostMapping()
    public ResponseEntity<Emprestimo> save(@RequestBody DadosEmprestimo dados) {
        Emprestimo emprestimo = service.add(dados);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimo.getId()).toUri()).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
