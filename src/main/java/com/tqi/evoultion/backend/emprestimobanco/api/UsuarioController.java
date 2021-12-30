package com.tqi.evoultion.backend.emprestimobanco.api;

import com.tqi.evoultion.backend.emprestimobanco.domain.event.RecursoCriadoEvent;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.service.UsuarioService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping(path="/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    private ApplicationEventPublisher publisher;

    public UsuarioController(UsuarioService usuarioService, ApplicationEventPublisher publisher) {
        this.usuarioService = usuarioService;
        this.publisher = publisher;
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> salvar(@Validated @RequestBody  Usuario usuario, HttpServletResponse response){
        Usuario u = usuarioService.salvarUsuario(usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, u.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }
}
