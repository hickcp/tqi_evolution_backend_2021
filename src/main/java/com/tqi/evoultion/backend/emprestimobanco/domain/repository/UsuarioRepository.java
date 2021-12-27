package com.tqi.evoultion.backend.emprestimobanco.domain.repository;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import org.springframework.data.repository.CrudRepository;



public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
