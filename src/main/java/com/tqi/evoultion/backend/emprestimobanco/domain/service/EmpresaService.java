package com.tqi.evoultion.backend.emprestimobanco.domain.service;

import com.tqi.evoultion.backend.emprestimobanco.domain.model.Empresa;
import com.tqi.evoultion.backend.emprestimobanco.domain.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService(EmpresaRepository empresaRepository){this.empresaRepository = empresaRepository;}


    public Empresa salvarEmpresa(Empresa e){  //"seta" a empresa para todos os usuarios q retornarem no getUsuario
        //e.getUsuarios().forEach(u -> u.setEmpresa(e));
        //e.getEmprestimos().forEach(u -> u.setEmpresa(e));
        return empresaRepository.save(e); //salva no BD as alterações
    }
}
