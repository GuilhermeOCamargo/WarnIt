package br.com.warnit.address.service

import br.com.warnit.address.model.Estado
import br.com.warnit.address.repository.EstadoRepository
import org.springframework.stereotype.Service

@Service
class EstadoService(private val estadoRepository: EstadoRepository){


    fun findByName(nome: String): Estado{
        return estadoRepository.findByNome(nome)
    }

    fun save(estado: Estado): Estado{
        return estadoRepository.save(estado)
    }

   /* fun findOrPopulate(nome: String, id: Long, uf: String): Estado{
        var estado = findByName(nome)
        if (estado == null) {

        }
    }*/
}