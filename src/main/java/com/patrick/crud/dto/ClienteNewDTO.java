package com.patrick.crud.dto;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private Integer cidadeId;

    public ClienteNewDTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }
}