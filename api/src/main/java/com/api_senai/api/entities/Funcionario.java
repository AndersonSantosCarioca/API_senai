package com.api_senai.api.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name ="funcionarios",
        uniqueConstraints = {
            @UniqueConstraint(name = "email+ukey", columnNames = "email"),
            @UniqueConstraint(name = "cpf_ukey", columnNames = "cpf"),
            @UniqueConstraint(name = "telefone_ukey", columnNames = "telefone")
        })
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    private String ctps;
    private String cargo;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "endereco", foreignKey = @ForeignKey(name = "endereco_fkey"))
    private Endereco endereco;
}