package com.rizzatto.biblioteca.controller;

import com.rizzatto.biblioteca.model.Cliente;
import com.rizzatto.biblioteca.model.dto.DadosCliente;
import com.rizzatto.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = service.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> getClienteByID(@PathVariable Long id) {
        Cliente cliente = service.getClienteID(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody DadosCliente dados) {
        Cliente cliente = service.add(dados);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri()).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
