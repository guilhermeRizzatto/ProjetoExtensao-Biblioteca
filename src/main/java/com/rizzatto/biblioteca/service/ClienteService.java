package com.rizzatto.biblioteca.service;

import com.rizzatto.biblioteca.model.Cliente;
import com.rizzatto.biblioteca.model.dto.DadosCliente;
import com.rizzatto.biblioteca.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Page<Cliente> getClientes(int pageNumber, int pageSize){
        Pageable paginacao = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(paginacao);
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
