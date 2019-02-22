package br.com.warnit.address.service;

import br.com.warnit.address.model.domain.Bairro;
import br.com.warnit.address.repository.BairroRepository;
import br.com.warnit.address.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Service
public class BairroService {
    @Autowired
    private BairroRepository bairroRepository;

    public Bairro findByName(String nomeBairro){
        Optional<Bairro> bairro = bairroRepository.findByNome(nomeBairro);
        return bairro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Nome: " +nomeBairro+
                " , Tipo: "+ Bairro.class.getSimpleName()));
    }

    public Bairro findOrPopulate(String nomeBairro, Long id){
        try{
            return findByName(nomeBairro);
        }catch (ObjectNotFoundException e){
            e.printStackTrace();
            return new Bairro(id, nomeBairro, null);
        }
    }

}
