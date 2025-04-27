package com.rizzatto.biblioteca.model;


import com.rizzatto.biblioteca.model.dto.DadosCliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy="cliente")
    List<Emprestimo> emprestimos = new ArrayList<>();

    public Cliente(DadosCliente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
}
