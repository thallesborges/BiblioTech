package dev.thallesborges.BiblioTech.entity;

import dev.thallesborges.BiblioTech.enums.LocacaoStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "locacoes")
public class LocacaoEntity extends AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private LivroEntity livro;

    @Column(name = "data_locacao", nullable = false)
    private LocalDate dataLocacao;

    @Future
    @Column(name = "data_prevista_devolucao", nullable = false)
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "data_devolucao_efetiva")
    private LocalDate dataDevolucaoEfetiva;

    private Boolean renovado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocacaoStatus status;

    @Column(name = "multa_valor")
    private BigDecimal multaValor;

    @Column(name = "data_pagamento_multa")
    private Instant dataPagamentoMulta;
}
