package com.tqi.evoultion.backend.emprestimobanco.api;

import com.tqi.evoultion.backend.emprestimobanco.domain.event.RecursoCriadoEvent;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Emprestimo;
import com.tqi.evoultion.backend.emprestimobanco.domain.service.EmprestimoService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping(path = "/emprestimo")
public class EmprestimoController {
    private EmprestimoService emprestimoService;
    private ApplicationEventPublisher publisher;

    public EmprestimoController(EmprestimoService emprestimoService, ApplicationEventPublisher publisher) {
        this.emprestimoService = emprestimoService;
        this.publisher = publisher;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<Emprestimo> salvar(@Validated @RequestBody Emprestimo emprestimo, HttpServletResponse response){
        Emprestimo e = emprestimoService.salvarEmprestimo(emprestimo);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, e.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Emprestimo> buscar(@PathVariable(name="id")Long id){
        return ResponseEntity.ok(emprestimoService.getEmprestimo(id));
    }
}
