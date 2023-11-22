package com.api_senai.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import jakarta.persistence.OneToOne;


import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "funcionarios", 
       uniqueConstraints = {
           @UniqueConstraint(name = "email_ukey", columnNames = "email"),
           @UniqueConstraint(name = "cpf_ukey", columnNames = "cpf"),

           @UniqueConstraint(name = "dataNascimento_ukey", columnNames = "dataNascimento"),


           @UniqueConstraint(name = "telefone_ukey", columnNames = "telefone")
       })
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ctps;
    private String login;
    private String senha;
    private boolean ativo;



    @OneToOne(mappedBy = "funcionario")
    private Conta conta;

    // public Cliente(){
    //     this.setAtivo(true);
    // }

    public void setAllAtributos (Cliente novoCliente) {
        this.setNome(novoCliente.getNome());
        this.setCpf(novoCliente.getCpf());
        this.setDataNascimento(novoCliente.getDataNascimento());
        this.setTelefone(novoCliente.getTelefone());
        this.setEmail(novoCliente.getEmail());
    }

}
