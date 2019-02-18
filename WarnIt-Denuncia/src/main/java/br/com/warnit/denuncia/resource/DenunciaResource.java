package br.com.warnit.denuncia.resource;

import br.com.warnit.denuncia.model.domain.Denuncia;
import br.com.warnit.denuncia.service.DenunciaService;
import br.com.warnit.denuncia.model.dto.DenunciaDTO;
import br.com.warnit.denuncia.model.vo.DenunciaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping
public class DenunciaResource {

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DenunciaVO> findById(@PathVariable Long id){
        Denuncia denuncia = denunciaService.findById(id);
        return ResponseEntity.ok(new DenunciaVO(denuncia));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody DenunciaDTO denunciaDTO){
        Denuncia denuncia = denunciaService.save(denunciaService.fromDto(denunciaDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(denuncia.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
