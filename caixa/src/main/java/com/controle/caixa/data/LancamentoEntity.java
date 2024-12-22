package com.controle.caixa.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="Lancamento")
public class LancamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message="Conta é obrigatória!")
    private Integer contaId;
    @NotNull(message="Data é obrigatória!")
    private Date dataLcto;
    @NotNull(message="Valor é obrigatório!")
    private double valor;
    @Size(max=1, message="Informe D para Débito e C para Crédito!")
    private String debcre;
    @NotNull(message="Histórico é obrigatório!")
    private Integer historicoId;
    private String complemento;
    private boolean status;
}
