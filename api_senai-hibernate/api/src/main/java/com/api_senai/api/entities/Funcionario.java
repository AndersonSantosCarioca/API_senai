package com.api_senai.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD:api_senai-hibernate/api/src/main/java/com/api_senai/api/entities/Funcionario.java
<<<<<<<< HEAD:api_senai-hibernate/api/src/main/java/com/api_senai/api/entities/Funcionario.java
========
import jakarta.persistence.OneToOne;
>>>>>>>> ce0237effc9e733216e3d75d892967a03cee9cd3:api/src/main/java/com/api_senai/api/entities/Cliente.java
=======
>>>>>>> ce0237effc9e733216e3d75d892967a03cee9cd3:api/src/main/java/com/api_senai/api/entities/Funcionario.java
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
<<<<<<< HEAD:api_senai-hibernate/api/src/main/java/com/api_senai/api/entities/Funcionario.java
           @UniqueConstraint(name = "dataNascimento_ukey", columnNames = "dataNascimento"),
=======
>>>>>>> ce0237effc9e733216e3d75d892967a03cee9cd3:api/src/main/java/com/api_senai/api/entities/Funcionario.java
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
<<<<<<< HEAD:api_senai-hibernate/api/src/main/java/com/api_senai/api/entities/Funcionario.java
<<<<<<<< HEAD:api_senai-hibernate/api/src/main/java/com/api_senai/api/entities/Funcionario.java
========

    @OneToOne(mappedBy = "cliente")
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
>>>>>>>> ce0237effc9e733216e3d75d892967a03cee9cd3:api/src/main/java/com/api_senai/api/entities/Cliente.java
=======
>>>>>>> ce0237effc9e733216e3d75d892967a03cee9cd3:api/src/main/java/com/api_senai/api/entities/Funcionario.java
}
