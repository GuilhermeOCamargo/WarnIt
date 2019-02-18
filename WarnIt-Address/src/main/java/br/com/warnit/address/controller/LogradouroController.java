package br.com.warnit.address.controller;

import br.com.warnit.address.model.domain.Logradouro;
import br.com.warnit.address.model.dto.LogradouroDTO;
import br.com.warnit.address.model.vo.LogradouroVO;
import br.com.warnit.address.service.LogradouroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@RestController
@RequestMapping()
public class LogradouroController {

    @Autowired
    private LogradouroService logradouroService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<LogradouroVO> findById(@PathVariable Long id){
        Logradouro logradouro = logradouroService.findById(id);
        return ResponseEntity.ok(new LogradouroVO(logradouro));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody LogradouroDTO logradouroDTO){
        Logradouro logradouro = logradouroService.save(logradouroService.fromDto(logradouroDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(logradouro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody LogradouroDTO logradouroDTO){
        logradouroDTO.setIdLogradouro(id);
        Logradouro logradouro = logradouroService.fromDto(logradouroDTO);
        logradouroService.save(logradouro);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        logradouroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
