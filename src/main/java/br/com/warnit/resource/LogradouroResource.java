package br.com.warnit.resource;

import br.com.warnit.model.ResponseDto.LogradouroResponseDTO;
import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.service.LogradouroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<?> findById(@PathVariable Long id){
        Logradouro logradouro = logradouroService.findById(id);
        return ResponseEntity.ok(LogradouroResponseDTO.getDto(logradouro));
    }
}
