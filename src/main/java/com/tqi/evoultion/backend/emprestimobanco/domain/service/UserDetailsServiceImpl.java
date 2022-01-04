package com.tqi.evoultion.backend.emprestimobanco.domain.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tqi.evoultion.backend.emprestimobanco.domain.data.UsuarioDTO;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.repository.UsuarioRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new UsuarioDTO(usuario);
    }

}
