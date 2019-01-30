package br.com.warnit.service;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.repository.LogradouroRepository;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Logradouro findById(Long id){
        Optional<Logradouro> logradouro = logradouroRepository.findById(id);
        return logradouro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+
                " Tipo: "+Logradouro.class.getSimpleName()));
    }
}
