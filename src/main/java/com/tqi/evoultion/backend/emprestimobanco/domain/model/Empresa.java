package com.tqi.evoultion.backend.emprestimobanco.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nome_empresa", nullable = false, length = 50)
    private String nome_empresa;

    @JsonIgnoreProperties("empresa")
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios = new ArrayList<>();

    @JsonIgnoreProperties("empresa")
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
