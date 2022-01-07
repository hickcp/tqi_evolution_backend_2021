package com.tqi.evoultion.backend.emprestimobanco.domain.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;


public class UsuarioDTO implements UserDetails {
	private static final long serialVersionUID = -8674157765065669789L;
	
	private final Optional<Usuario> usuario;
	
	public Long getId() {
		return usuario.orElse(new Usuario()).getId();
	}
	
	public Optional<Usuario> getUsuario() {
		return this.usuario;
	}

    public UsuarioDTO(Optional<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new Usuario()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new Usuario()).getEmail();
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