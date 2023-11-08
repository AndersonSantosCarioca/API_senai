package com.api_senai.api.entities;

import java.time.LocalDate;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    @OneToOne
    @JoinColumn(name = "endereco", foreignKey = @ForeignKey(name = "endereco_fkey"))
    private Endereco endereco;
}
