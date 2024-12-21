package com.controle.caixa.data;

@Data
@Entity
@Table(name="Conta")
public class ContaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min=5, message="Informe ao menos 5 caracteres para o campo descrição!")
    private String descricao;
    @Size(max=1, message="Informe D para Débito e C para Crédito!")
    private String natureza;
    @Size(max=1, message="Informe S para Sim e N para Não!")
    private String principal; 
    private boolean status;
}
