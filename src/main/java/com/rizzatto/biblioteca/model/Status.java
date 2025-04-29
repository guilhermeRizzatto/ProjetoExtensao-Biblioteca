package com.rizzatto.biblioteca.model;

public enum Status {

    DISPONIVEL("DISPONIVEL"),
    ALUGADO("ALUGADO");

    private String value;

    Status(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
