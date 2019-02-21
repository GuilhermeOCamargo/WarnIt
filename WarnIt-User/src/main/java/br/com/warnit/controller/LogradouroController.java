package br.com.warnit.controller;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.model.dto.LogradouroDTO;
import br.com.warnit.model.vo.LogradouroVO;
import br.com.warnit.service.LogradouroService;
import br.com.warnit.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logradouro")
public class LogradouroController {

    @Autowired
    private LogradouroService logradouroService;
    @Autowired
    private UsuarioService usuarioService;

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> addLogradouro(@RequestBody LogradouroDTO logradouroDTO, @PathVariable Long id){
        usuarioService.addLogradouro(logradouroDTO, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{usuarioId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<LogradouroVO> findByUsuario(@PathVariable Long usuarioId){
        Logradouro logradouro = logradouroService.findByUsuario(usuarioId);
        return ResponseEntity.ok(new LogradouroVO(logradouro));
    }
}
