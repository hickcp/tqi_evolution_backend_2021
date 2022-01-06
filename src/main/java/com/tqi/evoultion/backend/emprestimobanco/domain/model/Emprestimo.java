package com.tqi.evoultion.backend.emprestimobanco.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ValorEmprestimo", nullable = false)
    private Double valorEmprestimo;

    @Column(name="Parcelas", nullable = false, length = 30)
    private Integer parcelas;

    @Column(name="PrimeiraParcela", nullable = false)
    private Date primeiraParcela;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEprestimo(Double valor_emprestimo) {
        this.valorEmprestimo = valor_emprestimo;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Date getPrimeiraParcela() {
        return primeiraParcela;
    }

    public void setPrimeiraParcela(Date primeiraParcela) {
        this.primeiraParcela = primeiraParcela;
    }
}
