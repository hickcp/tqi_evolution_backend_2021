package com.tqi.evoultion.backend.emprestimobanco.domain.service;


import com.tqi.evoultion.backend.emprestimobanco.domain.model.Emprestimo;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo salvarEmprestimo(Emprestimo e){
            return emprestimoRepository.save(e);

    }


    public List<Emprestimo> emprestimosPorUsuario(Usuario usuario){
        return emprestimoRepository.findAllByUsuario(usuario);
    }

}
