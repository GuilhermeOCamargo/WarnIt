package br.com.warnit.address.service;

import br.com.warnit.address.model.domain.*;
import br.com.warnit.address.model.dto.LogradouroDTO;
import br.com.warnit.address.repository.LogradouroRepository;
import br.com.warnit.address.service.exceptions.DataIntegrityException;
import br.com.warnit.address.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@Service
public class LogradouroService {

    @Autowired
    private LogradouroRepository logradouroRepository;
    @Autowired
    private LocalidadeService localidadeService;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private BairroService bairroService;
    @Autowired
    private CidadeService cidadeService;
    public Logradouro findById(Long id){
        Optional<Logradouro> logradouro = logradouroRepository.findById(id);
        return logradouro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+
                " Tipo: "+Logradouro.class.getSimpleName()));
    }

    @Transactional
    public Logradouro save(Logradouro logradouro){
        return logradouroRepository.save(logradouro);
    }

    public void deleteById(Long id){
        findById(id);
        try{
            logradouroRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir o logradouro.");
        }
    }

    /**
     * Convert a {@link LogradouroDTO} in a {@link Logradouro}
     * @param dto
     * @return Logradouro
     * */
    public Logradouro fromDto(LogradouroDTO dto){
        Localidade localidade = null;
        Estado estado;
        Cidade cidade;
        Bairro bairro;
        Logradouro logradouro;
        boolean isLocalidadePersisted = true;
        try{
            localidade = localidadeService.findByCep(dto.getCep());
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
        if(dto.getIdLogradouro() != null){
            logradouro = findById(dto.getIdLogradouro());
            logradouro.setLocalidade(localidade);
            logradouro.setNumero(dto.getNumero());
            logradouro.setComplemento(dto.getComplemento());
        }else{
            logradouro = new Logradouro(dto.getIdLogradouro(), localidade, dto.getNumero(), dto.getComplemento());
        }
        return logradouro;
    }
}
