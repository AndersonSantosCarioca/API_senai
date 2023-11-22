package com.api_senai.api.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "operacoes")
@JasonIgnoreProperties({"origem", "destino"})

public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dataHora;
    private BigDecimal valor;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    private Conta origem;

    @ManyToOne
    @JoinColumn(name ="conta_destino_id")
    private Conta destino;
    public void setAllAtributos(Operacao operacaoAtualizada);
    
}
