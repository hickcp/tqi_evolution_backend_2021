package com.tqi.evoultion.backend.emprestimobanco.domain.repository;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
