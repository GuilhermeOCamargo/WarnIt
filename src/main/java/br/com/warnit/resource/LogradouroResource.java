package br.com.warnit.resource;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.model.dto.LogradouroDTO;
import br.com.warnit.service.LogradouroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@RestController
@RequestMapping("/logradouros")
public class LogradouroResource {

    @Autowired
    private LogradouroService logradouroService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<LogradouroDTO> findById(@PathVariable Long id){
        Logradouro logradouro = logradouroService.findById(id);
        return ResponseEntity.ok(new LogradouroDTO(logradouro));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> insert(@RequestBody LogradouroDTO logradouroDTO){
        Logradouro logradouro = logradouroService.save(logradouroService.fromDto(logradouroDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(logradouro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody LogradouroDTO logradouroDTO){
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
