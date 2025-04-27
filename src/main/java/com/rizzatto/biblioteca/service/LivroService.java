package com.rizzatto.biblioteca.service;

import com.rizzatto.biblioteca.model.Livro;
import com.rizzatto.biblioteca.model.dto.DadosLivro;
import com.rizzatto.biblioteca.model.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> getLivros(){
        return repository.findAll();
    }

    public Livro getLivroID(Long id){
        return repository.getReferenceById(id);
    }

    public Livro add(DadosLivro dados){
        Livro livro = new Livro(dados);
        return repository.save(livro);
    }

    public void delete(Long id){
        Livro livro = repository.getReferenceById(id);
        repository.delete(livro);
    }
}
