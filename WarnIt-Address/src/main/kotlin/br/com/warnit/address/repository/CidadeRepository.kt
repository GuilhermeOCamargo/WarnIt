package br.com.warnit.address.repository

import br.com.warnit.address.model.Cidade
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Repository
interface CidadeRepository: CrudRepository<Cidade, Long>{
    @Transactional(readOnly = true)
    fun findByNome(nomeCidade: String): Optional<Cidade>
}