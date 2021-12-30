package com.tqi.evoultion.backend.emprestimobanco.domain.model;

import javax.persistence.*;

@Entity
public class EnderecoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Rua", nullable = false, length = 50)
    private String rua;

    @Column(name = "Numero", nullable = false, length = 50)
    private String numero;

    @Column(name = "Bairro", nullable = false, length = 50)
    private String bairro;

    @Column(name = "Cidade", nullable = false, length = 50)
    private String cidade;

    @Column(name = "Estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "Cep", nullable = false, length = 50)
    private String cep;

    @OneToOne(mappedBy = "enderecoUsuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
