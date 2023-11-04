package com.api_senai.api.entities;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
}
