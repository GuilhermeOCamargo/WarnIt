package br.com.warnit.address.service

import br.com.warnit.address.repository.BairroRepository
import br.com.warnit.address.model.Bairro
import br.com.warnit.address.service.exception.ObjectNotFoundException
import org.springframework.stereotype.Service

@Service
class BairroService(private val bairroRepository: BairroRepository){

    fun findByName(nome: String): Bairro {
        return bairroRepository.findByNome(nome)
                .orElseThrow {ObjectNotFoundException("""Objeto não encontrado. Nome: $nome
                     Tipo: ${Bairro::class.simpleName}""")}
    }

    fun findOrPopulate(nome: String, id: Long?): Bairro {
        return try{findByName(nome)}catch (e: ObjectNotFoundException){Bairro(id, nome)}
    }
}