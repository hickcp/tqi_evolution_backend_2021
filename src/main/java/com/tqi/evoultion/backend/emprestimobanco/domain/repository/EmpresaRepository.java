package com.tqi.evoultion.backend.emprestimobanco.domain.repository;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
