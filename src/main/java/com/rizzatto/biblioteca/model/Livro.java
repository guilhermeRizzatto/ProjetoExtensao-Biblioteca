package com.rizzatto.biblioteca.model;

import com.rizzatto.biblioteca.model.dto.DadosLivro;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String ano;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "livro")
    private Emprestimo emprestimo;

    public Livro(DadosLivro dados){
        this.titulo = dados.titulo();
        this.ano = dados.ano();
        this.status = Status.valueOf(dados.status());
    }
}
