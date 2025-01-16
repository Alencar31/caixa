package com.controle.caixa.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="Conta")
public class ContaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min=5, message="Informe ao menos 5 caracteres para o campo descrição!")
    private String descricao;
    @Size(max=1, message="Informe S para Sim e N para Não!")
    private String principal; 
    private boolean status;
}