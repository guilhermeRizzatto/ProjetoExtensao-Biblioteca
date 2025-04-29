package com.rizzatto.biblioteca.service;

import com.rizzatto.biblioteca.model.Emprestimo;
import com.rizzatto.biblioteca.model.dto.DadosEmprestimo;
import com.rizzatto.biblioteca.model.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    public Page<Emprestimo> getEmprestimos(int pageNumber, int pageSize){
        Pageable paginacao = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(paginacao);
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
