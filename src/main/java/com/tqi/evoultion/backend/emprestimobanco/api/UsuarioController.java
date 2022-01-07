package com.tqi.evoultion.backend.emprestimobanco.api;

import com.tqi.evoultion.backend.emprestimobanco.domain.event.RecursoCriadoEvent;
import com.tqi.evoultion.backend.emprestimobanco.domain.model.Usuario;
import com.tqi.evoultion.backend.emprestimobanco.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping(path="/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ApplicationEventPublisher publisher;

    private PasswordEncoder encoder;

    public UsuarioController(UsuarioService usuarioService, ApplicationEventPublisher publisher, PasswordEncoder encoder) {
        this.usuarioService = usuarioService;
        this.publisher = publisher;
        this.encoder = encoder;
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> salvar(@Validated @RequestBody  Usuario usuario/*, PasswordEncoder encoder*/, HttpServletResponse response){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));

    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<Usuario> buscar(@PathVariable(name = "email") String email){
        return ResponseEntity.ok(usuarioService.getUsuario(email));
    }

}
