package com.controle.caixa.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Calendar;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="lancamento")
public class LancamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message="Conta é obrigatória!")
    private Integer contaId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dataLcto;
    @NotNull(message="Valor é obrigatório!")
    private double valor;
    @NotNull(message="Histórico é obrigatório!")
    private Integer historicoId;
    private String complemento;
    private boolean status;
}