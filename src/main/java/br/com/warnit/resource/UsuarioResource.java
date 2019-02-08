package br.com.warnit.resource;

import br.com.warnit.model.domain.Usuario;
import br.com.warnit.model.dto.UsuarioDTO;
import br.com.warnit.model.dto.UsuarioLoginDTO;
import br.com.warnit.model.vo.UsuarioVO;
import br.com.warnit.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
/**
 * @author Guilherme Camargo
 * @since 02/02/2019
 * @version 1.0
 * */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsuarioVO> authenticate(@RequestBody UsuarioLoginDTO dto){
        Usuario usuario = usuarioService.authenticate(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(new UsuarioVO(usuario));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsuarioVO> findById(@PathVariable Long id){
        Usuario usuario= usuarioService.findById(id);
        return ResponseEntity.ok(new UsuarioVO(usuario));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.save(usuarioService.fromDto(usuarioDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDto){
        Usuario usuario = usuarioService.fromDto(usuarioDto);
        usuario.setId(id);
        usuarioService.save(usuario);
        return ResponseEntity.noContent().build();
    }
    //Todo change UsuarioDto to UsuarioPasswordDto
    @PutMapping(value = "/password/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        usuarioDTO.setId(id);
        usuarioService.updatePassword(usuarioDTO);
        return ResponseEntity.noContent().build();
    }

}
