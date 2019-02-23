package br.com.warnit.address.controller

import br.com.warnit.address.model.Localidade
import br.com.warnit.address.model.dto.LocalidadeDto
import br.com.warnit.address.service.LocalidadeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class LocalidadeController(private val localidadeService: LocalidadeService){

    @GetMapping(value = "/{cep}")
    fun findByCep(@PathVariable cep: String): ResponseEntity<Localidade>{
        return ResponseEntity.ok(localidadeService.findByCep(cep))
    }

    @PostMapping
    fun insert(@RequestBody localidadeDto: LocalidadeDto): ResponseEntity<Localidade>{
        return ResponseEntity.ok(localidadeService.save(localidadeService.fromDto(localidadeDto)))
    }
}