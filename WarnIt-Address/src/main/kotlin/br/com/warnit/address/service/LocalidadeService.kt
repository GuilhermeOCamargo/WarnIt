package br.com.warnit.address.service

import br.com.warnit.address.model.Localidade
import br.com.warnit.address.model.dto.LocalidadeDto
import br.com.warnit.address.repository.LocalidadeRepository
import br.com.warnit.address.service.exception.ObjectNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class LocalidadeService(private val localidadeRepository: LocalidadeRepository,
                             private val estadoService: EstadoService,
                             private val cidadeService: CidadeService,
                             private val bairroService: BairroService){

    fun findByCep(cep: String): Localidade {
        return localidadeRepository.findByCep(cep).orElseThrow{
            ObjectNotFoundException("""Objeto não encontrado. Cep: $cep
                     Tipo: ${Localidade::class.simpleName}""")}
    }

    @Transactional
    open fun save(localidade: Localidade): Localidade {
        return localidadeRepository.save(localidade)
    }

    /**
     * Convert a [LocalidadeDTO] in a [Localidade]
     * @param dto
     * @return Logradouro
     */
    fun fromDto(dto: LocalidadeDto): Localidade {
        var localidade: Localidade
        try {
            localidade = findByCep(dto.cep)
        } catch (e: ObjectNotFoundException) {
            var bairro = bairroService.findOrPopulate(dto.nomeBairro, dto.idBairro)
            if (bairro.id == null) {
                bairro.cidade = cidadeService.findOrPopulate(dto.nomeCidade, dto.idCidade)
                if (bairro.cidade!!.id == null) {
                    bairro.cidade!!.estado = estadoService.findOrPopulate(dto.nomeEstado, dto.idEstado, dto.uf)
                }
            }
            localidade = Localidade(dto.idLocalidade, dto.nomeRua, bairro, dto.cep)
        }
        return localidade
    }

}