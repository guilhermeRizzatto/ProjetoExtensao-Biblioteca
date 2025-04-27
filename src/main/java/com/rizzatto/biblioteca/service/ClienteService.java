package com.rizzatto.biblioteca.service;

import com.rizzatto.biblioteca.model.Cliente;
import com.rizzatto.biblioteca.model.dto.DadosCliente;
import com.rizzatto.biblioteca.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public Cliente getClienteID(Long id){
        return repository.getReferenceById(id);
    }

    public Cliente add(DadosCliente dados){
        Cliente cliente = new Cliente(dados);
        return repository.save(cliente);
    }

    public void delete(Long id){
        Cliente cliente = repository.getReferenceById(id);
        repository.delete(cliente);
    }
}
