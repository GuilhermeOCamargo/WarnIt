package br.com.warnit.address.service

import br.com.warnit.address.repository.CidadeRepository
import org.springframework.stereotype.Service
import br.com.warnit.address.model.Cidade
import br.com.warnit.address.service.exception.ObjectNotFoundException


@Service
class CidadeService(private val cidadeRepository: CidadeRepository){

    fun findByName(nome: String): Cidade {
        return cidadeRepository.findByNome(nome)
                .orElseThrow {ObjectNotFoundException("""Objeto não encontrado. Nome: $nome
                     Tipo: ${Cidade::class.simpleName}""")}

    }

    fun findOrPopulate(nome: String, id: Long?): Cidade {
        return try{findByName(nome)}catch (e: ObjectNotFoundException){Cidade(id, nome)}
    }
}