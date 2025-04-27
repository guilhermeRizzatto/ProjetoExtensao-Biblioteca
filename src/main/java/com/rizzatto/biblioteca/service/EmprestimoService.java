package com.rizzatto.biblioteca.service;

import com.rizzatto.biblioteca.model.Emprestimo;
import com.rizzatto.biblioteca.model.dto.DadosEmprestimo;
import com.rizzatto.biblioteca.model.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    public List<Emprestimo> getEmprestimos(){
        return repository.findAll();
    }

    public Emprestimo getEmprestimoID(Long id){
        return repository.getReferenceById(id);
    }

    public Emprestimo add(DadosEmprestimo dados){
        Emprestimo emprestimo = new Emprestimo(dados);
        return repository.save(emprestimo);
    }

    public void delete(Long id){
        Emprestimo emprestimo = repository.getReferenceById(id);
        repository.delete(emprestimo);
    }
}
