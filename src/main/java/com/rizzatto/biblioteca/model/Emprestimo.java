package com.rizzatto.biblioteca.model;

import com.rizzatto.biblioteca.model.dto.DadosEmprestimo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livro;

    public Emprestimo(DadosEmprestimo dados){
        this.dataEmprestimo = LocalDate.parse(dados.dataEmprestimo());
        this.dataDevolucaoPrevista = LocalDate.parse(dados.dataDevolucaoPrevista());
        this.dataDevolucaoReal = LocalDate.parse(dados.dataDevolucaoReal());
    }

}
