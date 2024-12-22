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
@Table(name="Saldo")
public class SaldoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message="Conta é obrigatória!")
    private Integer contaId;
    @NotNull(message="Ano é obrigatório!")
    private Integer ano;
    @NotNull(message="Mês é obrigatório!")
    private Integer mes;   
    @NotNull(message="Saldo Anterior é obrigatório!")
    private double saldoAnterior;
    @NotNull(message="Valor à Crédito é obrigatório!")
    private double credito;
    @NotNull(message="Valor à Débito é obrigatório!")
    private double debito;
    @NotNull(message="Saldo Final é obrigatório!")
    private double saldoAtual; 
    private boolean status;
}
