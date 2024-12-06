package br.com.rappidu.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Customer {
    private String id;
    private String name;
    private Cpf cpf;

    public void setCpf(String documentNumber) {
        this.cpf = new Cpf(documentNumber);
    }

    public String getCpf() {
        return this.cpf.get();
    }
}
