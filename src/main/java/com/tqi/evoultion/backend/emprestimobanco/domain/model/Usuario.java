package com.tqi.evoultion.backend.emprestimobanco.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "Nome_Usuario", length = 50)
    private String nome_usuario;

    @Column(nullable = false, name = "Email", length = 50, unique = true)
    private String email;

    @Column(nullable = false, name = "Senha", length = 50)
    private String senha;

    @Column(nullable = false, name = "CPF", length = 50, unique = true)
    private String cpf;

    @Column(nullable = false, name = "RG", length = 50, unique = true)
    private String rg;

    @Column(nullable = false, name = "Renda")
    private Long renda;

    @Column(nullable = false, name="Endereco")
    private String endereco_completo;

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }


    @JsonIgnoreProperties("usuario")
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprestimo> emprestimos = new ArrayList<>();

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

    public Long getRenda() {
        return renda;
    }

    public void setRenda(Long renda) {
        this.renda = renda;
    }

    public String getEndereco_completo() {
        return endereco_completo;
    }

    public void setEndereco_completo(String endereco_completo) {
        this.endereco_completo = endereco_completo;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
