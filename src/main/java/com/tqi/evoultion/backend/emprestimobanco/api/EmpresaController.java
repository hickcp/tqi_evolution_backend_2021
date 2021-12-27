package com.tqi.evoultion.backend.emprestimobanco.api;

import com.tqi.evoultion.backend.emprestimobanco.domain.event.RecursoCriadoEvent;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Empresa;
import com.tqi.evoultion.backend.emprestimobanco.domain.service.EmpresaService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping(path = "/usuario")
public class EmpresaController {

    private EmpresaService empresaService;

    private ApplicationEventPublisher publisher;

    public EmpresaController(EmpresaService empresaService, ApplicationEventPublisher publisher){
        this.empresaService = empresaService;
        this.publisher = publisher;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Empresa> salvar(@Validated @RequestBody Empresa empresa, HttpServletResponse response){

        Empresa e = empresaService.salvarEmpresa(empresa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, e.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }
}
