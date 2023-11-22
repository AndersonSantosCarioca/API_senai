package com.api_senai.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int numero;
    double saldo;
    // Funcionario gerente;

    @OneToOne
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "cliente_fkey"))
    Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "funcionario", foreignKey = @ForeignKey(name = "funcionario_fkey"))
    Funcionario funcionario;

    public void setAtivo(boolean b) {
    }

    public void setAllAtributosMapping(Conta contaAtualizado) {
    }

    public void setAllAtributos(Conta contaAtualizada) {
    }
}
