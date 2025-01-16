package com.controle.caixa.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="saldo")
public class SaldoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message="Conta é obrigatória!")
    private Integer contaId;
    @NotNull(message="Saldo Atual é obrigatório!")
    private double saldoAtual; 
    private boolean status;
}
