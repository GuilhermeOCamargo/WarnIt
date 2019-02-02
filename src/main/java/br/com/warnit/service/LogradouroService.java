package br.com.warnit.service;

import br.com.warnit.model.domain.*;
import br.com.warnit.model.dtos.newDto.LogradouroDTO;
import br.com.warnit.repository.LogradouroRepository;
import br.com.warnit.service.exceptions.DataIntegrityException;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
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
    private RuaService ruaService;
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
    public Logradouro insert(Logradouro logradouro){
        return logradouroRepository.save(logradouro);
    }

    @Transactional
    public Logradouro update(Logradouro logradouro){
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
        Rua rua = null;
        Estado estado;
        Cidade cidade;
        Bairro bairro;
        boolean isRuaPersisted = true;
        try{
            rua = ruaService.findByCep(dto.getCep());
        }catch (ObjectNotFoundException e){
            isRuaPersisted = false;
        }
        if(!isRuaPersisted){
            estado = estadoService.findOrPopulate(dto.getNomeEstado(), dto.getIdEstado(), dto.getUf());
            cidade = cidadeService.findOrPopulate(dto.getNomeCidade(), dto.getIdCidade());
            bairro = bairroService.findOrPopulate(dto.getNomeBairro(), dto.getIdBairro());
            cidade.setEstado(estado);
            bairro.setCidade(cidade);
            rua = new Rua(dto.getIdRua(), dto.getNomeRua(), bairro, dto.getCep());
        }
        Logradouro logradouro = new Logradouro(dto.getIdLogradouro(), rua, dto.getNumero(), dto.getComplemento());
        return logradouro;
    }
}
