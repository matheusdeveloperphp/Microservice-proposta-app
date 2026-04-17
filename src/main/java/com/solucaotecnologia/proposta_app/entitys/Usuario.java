package com.solucaotecnologia.proposta_app.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    @Column(name = "sobrenome", nullable = false, length = 100)
    private String sobrenome;

    @NotBlank(message = "CPF é obrigatório")
    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @NotNull(message = "Renda é obrigatória")
    @PositiveOrZero(message = "Renda não pode ser negativa")
    @Column(name = "renda", nullable = false)
    private Double renda;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Proposta proposta;
}