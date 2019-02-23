package br.com.warnit.address.repository

import br.com.warnit.address.model.Localidade
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import java.util.*


interface LocalidadeRepository: CrudRepository<Localidade, Long>{
    @Transactional(readOnly = true)
    fun findByCep(cep: String): Optional<Localidade>
}