package br.com.warnit.address.repository

import br.com.warnit.address.model.Bairro
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*
@Repository
interface BairroRepository: CrudRepository<Bairro, Long>{
    @Transactional(readOnly = true)
    fun findByNome(nome: String): Optional<Bairro>
}