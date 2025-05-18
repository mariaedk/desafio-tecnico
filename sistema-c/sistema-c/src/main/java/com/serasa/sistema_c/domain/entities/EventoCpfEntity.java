package com.serasa.sistema_c.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa eventos atrelados a um cpf.
 */
@Entity
@Table(name = "evento_cpf", indexes = {
        @Index(name = "idx_evento_cpf", columnList = "nr_cpf")
})
public class EventoCpfEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nr_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bureau")
    @NotNull
    private ConsultaBureauEntity ultimaConsultaBureau;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_evento_cpf", referencedColumnName = "id", nullable = false)
    private List<MovimentacaoFinanceiraEntity> movimentacoesRecentes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ultima_compra_cartao")
    @NotNull
    private CompraCartaoEntity ultimaCompraCartao;

    public EventoCpfEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ConsultaBureauEntity getUltimaConsultaBureau() {
        return ultimaConsultaBureau;
    }

    public void setUltimaConsultaBureau(ConsultaBureauEntity ultimaConsultaBureau) {
        this.ultimaConsultaBureau = ultimaConsultaBureau;
    }

    public List<MovimentacaoFinanceiraEntity> getMovimentacoesRecentes() {
        return movimentacoesRecentes;
    }

    public void setMovimentacoesRecentes(List<MovimentacaoFinanceiraEntity> movimentacoesRecentes) {
        this.movimentacoesRecentes = movimentacoesRecentes;
    }

    public CompraCartaoEntity getUltimaCompraCartao() {
        return ultimaCompraCartao;
    }

    public void setUltimaCompraCartao(CompraCartaoEntity ultimaCompraCartao) {
        this.ultimaCompraCartao = ultimaCompraCartao;
    }
}
