package br.com.warnit.service;

import br.com.warnit.model.domain.Cidade;
import br.com.warnit.repository.CidadeRepository;
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
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade findByName(String nomeCidade){
        Optional<Cidade> cidade = cidadeRepository.findByNome(nomeCidade);
        return cidade.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Nome: "+nomeCidade+
                " Tipo: "+ Cidade.class.getSimpleName()));
    }

    public Cidade findOrPopulate(String nomeCidade, Long id){
        try{
            return findByName(nomeCidade);
        }catch (ObjectNotFoundException e){
            e.printStackTrace();
            return new Cidade(id, nomeCidade, null);
        }
    }
}
