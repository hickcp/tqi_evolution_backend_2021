package com.tqi.evoultion.backend.emprestimobanco.domain.service;


import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario u){

        return usuarioRepository.save(u);
    }
}
