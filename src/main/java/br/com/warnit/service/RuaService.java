package br.com.warnit.service;

import br.com.warnit.model.domain.Rua;
import br.com.warnit.repository.RuaRepository;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Service
public class RuaService {
    @Autowired
    private RuaRepository ruaRepository;

    public Rua findByCep(String cep){
        Optional<Rua> rua = ruaRepository.findByCep(cep);
        return rua.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Cep: " + cep+
                " Tipo: "+ Rua.class.getSimpleName()));
    }

}
