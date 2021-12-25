package com.tqi.evoultion.backend.emprestimobanco.domain.model;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "Nome_Usuario", length = 50)
    private String nome_usuario;

    @Column(nullable = false, name = "Email", length = 50)
    private String email;

    @Column(nullable = false, name = "Senha", length = 50)
    private String senha;

    @Column(nullable = false, name = "CPF", length = 50)
    private String cpf;

    @Column(nullable = false, name = "RG", length = 50)
    private String rg;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
