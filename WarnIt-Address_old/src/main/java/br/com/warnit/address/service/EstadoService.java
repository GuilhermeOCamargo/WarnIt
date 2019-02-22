package br.com.warnit.address.service;

import br.com.warnit.address.model.domain.Estado;
import br.com.warnit.address.repository.EstadoRepository;
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
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public Estado findByName(String nomeEstado){
        Optional<Estado> estado = estadoRepository.findByNomeEstado(nomeEstado);
        return estado.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Nome: "+ nomeEstado+
                " , Tipo: "+ Estado.class.getSimpleName()));
    }

    public Estado findOrPopulate(String nomeEstado, Long idEstado, String uf){
        try{
            return findByName(nomeEstado);
        }catch (ObjectNotFoundException e){
            e.printStackTrace();
            return new Estado(idEstado, nomeEstado, uf);
        }
    }
}
