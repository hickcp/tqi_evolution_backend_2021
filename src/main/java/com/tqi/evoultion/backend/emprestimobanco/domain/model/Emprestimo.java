package com.tqi.evoultion.backend.emprestimobanco.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Valor_Emprestimo", nullable = false)
    private Double valor_emprestimo;

    @Column(name="Parcelas", nullable = false, length = 30)
    private Integer parcelas;

    @Column(name="Primeira_Parcela", nullable = false)
    private Date primeira_parcela;

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor_emprestimo() {
        return valor_emprestimo;
    }

    public void setValor_emprestimo(Double valor_emprestimo) {
        this.valor_emprestimo = valor_emprestimo;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Date getPrimeira_parcela() {
        return primeira_parcela;
    }

    public void setPrimeira_parcela(Date primeira_parcela) {
        this.primeira_parcela = primeira_parcela;
    }
}
