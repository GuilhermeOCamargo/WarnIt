package br.com.warnit.address.service

import br.com.warnit.address.model.Estado
import br.com.warnit.address.repository.EstadoRepository
import br.com.warnit.address.service.exception.ObjectNotFoundException
import org.springframework.stereotype.Service

@Service
class EstadoService(private val estadoRepository: EstadoRepository){


    fun findByName(nome: String): Estado{
        return estadoRepository.findByNome(nome)
                .orElseThrow {ObjectNotFoundException("""Objeto não encontrado. Nome: $nome
                    Tipo: ${Estado::class.simpleName}""")}
    }

    fun findOrPopulate(nome: String, id: Long?, uf: String): Estado{
        return try{findByName(nome)}catch (e: ObjectNotFoundException){Estado(id, nome, uf)}
    }
}