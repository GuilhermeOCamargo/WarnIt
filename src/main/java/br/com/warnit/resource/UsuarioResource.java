package br.com.warnit.resource;

import br.com.warnit.model.domain.Usuario;
import br.com.warnit.model.dto.UsuarioLoginDTO;
import br.com.warnit.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> authenticate(@RequestBody UsuarioLoginDTO dto){
        Usuario usuario = usuarioService.authenticate(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(usuario);
    }
}
