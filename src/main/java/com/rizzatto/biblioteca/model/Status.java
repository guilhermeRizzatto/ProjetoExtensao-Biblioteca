package com.rizzatto.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum Status {

    DISPONIVEL("DISPONIVEL"),
    ALUGADO("ALUGADO");

    private String value;

    Status(String value){
        this.value = value;
    }


}
