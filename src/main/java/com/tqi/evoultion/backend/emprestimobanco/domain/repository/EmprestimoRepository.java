package com.tqi.evoultion.backend.emprestimobanco.domain.repository;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Emprestimo;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findAllByUsuario (Usuario usuario);
}
