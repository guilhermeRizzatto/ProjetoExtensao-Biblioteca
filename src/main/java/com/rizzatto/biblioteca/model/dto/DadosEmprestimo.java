package com.rizzatto.biblioteca.model.dto;

import com.rizzatto.biblioteca.model.Emprestimo;

public record DadosEmprestimo(Long id, String dataEmprestimo, String dataDevolucaoPrevista, String dataDevolucaoReal) {

    public DadosEmprestimo(Emprestimo emprestimo) {
        this(emprestimo.getId(), emprestimo.getDataEmprestimo().toString(), emprestimo.getDataDevolucaoPrevista().toString(), emprestimo.getDataDevolucaoReal().toString());
    }
}
