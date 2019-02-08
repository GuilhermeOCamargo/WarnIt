package br.com.warnit.service;

import br.com.warnit.model.domain.Bairro;
import br.com.warnit.model.domain.Cidade;
import br.com.warnit.model.domain.Estado;
import br.com.warnit.model.domain.Localidade;
import br.com.warnit.model.dto.LocalidadeDTO;
import br.com.warnit.repository.LocalidadeRepository;
import br.com.warnit.resource.exceptions.BairroService;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Service
public class LocalidadeService {
    @Autowired
    private LocalidadeRepository localidadeRepository;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private BairroService bairroService;
    @Autowired
    private CidadeService cidadeService;

    public Localidade findByCep(String cep){
        Optional<Localidade> localidade = localidadeRepository.findByCep(cep);
        return localidade.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Cep: " + cep+
                " Tipo: "+ Localidade.class.getSimpleName()));
    }
    @Transactional
    public  Localidade save(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    /**
     * Convert a {@link LocalidadeDTO} in a {@link Localidade}
     * @param dto
     * @return Logradouro
     * */
    public Localidade fromDto(LocalidadeDTO dto){
        Localidade localidade = null;
        Estado estado;
        Cidade cidade;
        Bairro bairro;
        boolean isLocalidadePersisted = true;
        try{
            localidade = findByCep(dto.getCep());
        }catch (ObjectNotFoundException e){
            isLocalidadePersisted = false;
        }
        if(!isLocalidadePersisted){
            estado = estadoService.findOrPopulate(dto.getNomeEstado(), dto.getIdEstado(), dto.getUf());
            cidade = cidadeService.findOrPopulate(dto.getNomeCidade(), dto.getIdCidade());
            bairro = bairroService.findOrPopulate(dto.getNomeBairro(), dto.getIdBairro());
            cidade.setEstado(estado);
            bairro.setCidade(cidade);
            localidade = new Localidade(dto.getIdLocalidade(), dto.getNomeLocalidade(), bairro, dto.getCep());
        }
        return localidade;
    }

}
