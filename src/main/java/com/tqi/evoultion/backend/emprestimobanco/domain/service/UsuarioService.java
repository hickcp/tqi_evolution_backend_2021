package com.tqi.evoultion.backend.emprestimobanco.domain.service;


import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario u){

        return usuarioRepository.save(u);
    }
    public Usuario getUsuario(String email){
        return usuarioRepository.findByEmail(email);
    }
}
