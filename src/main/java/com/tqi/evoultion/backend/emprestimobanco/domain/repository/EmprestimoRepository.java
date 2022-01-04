package com.tqi.evoultion.backend.emprestimobanco.domain.repository;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
