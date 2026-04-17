package com.solucaotecnologia.proposta_app.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "proposta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Valor solicitado é obrigatório")
    @Positive(message = "Valor solicitado deve ser positivo")
    @Column(name = "valor_solicitado", nullable = false)
    private Double valorSolicitado;

    @NotNull(message = "Prazo de pagamento é obrigatório")
    @Positive(message = "Prazo deve ser positivo")
    @Column(name = "prazo_pagamento", nullable = false)
    private Integer prazoPagamento;

    // Boolean (wrapper) permite null = "ainda não avaliada"
    @Column(name = "aprovada")
    private Boolean aprovada;

    @Column(name = "integrada", nullable = false)
    private boolean integrada = false;

    @Column(name = "observacao", length = 500)
    private String observacao;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}