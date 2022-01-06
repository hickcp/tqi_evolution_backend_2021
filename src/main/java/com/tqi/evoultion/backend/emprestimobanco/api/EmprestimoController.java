package com.tqi.evoultion.backend.emprestimobanco.api;

import com.tqi.evoultion.backend.emprestimobanco.domain.event.RecursoCriadoEvent;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Emprestimo;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.repository.UsuarioRepository;
import com.tqi.evoultion.backend.emprestimobanco.domain.service.EmprestimoService;
import com.tqi.evoultion.backend.emprestimobanco.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/emprestimo")
public class EmprestimoController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmprestimoService emprestimoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private UsuarioService usuarioService;


    public EmprestimoController(EmprestimoService emprestimoService, ApplicationEventPublisher publisher) {
        this.emprestimoService = emprestimoService;
        this.publisher = publisher;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<Object> salvar(@Validated @RequestBody Emprestimo emprestimo, HttpServletResponse response, Authentication auth){
        if (emprestimo.getParcelas() == 60 || emprestimo.getParcelas() <60) {
            String email = auth.getName();
            Usuario usuario = usuarioRepository.findByEmail(email).get();
            emprestimo.setUsuario(usuario);
            Emprestimo e = emprestimoService.salvarEmprestimo(emprestimo);
            publisher.publishEvent(new RecursoCriadoEvent(this, response, e.getId()));
            return ResponseEntity.status(HttpStatus.CREATED).body(e);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("");
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<Emprestimo>> buscar(Authentication auth){
        String email = auth.getName();
        return ResponseEntity.ok(emprestimoService.emprestimosPorUsuario(usuarioService.getUsuario(email)));

    }

}
