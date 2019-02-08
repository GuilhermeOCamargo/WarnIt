package br.com.warnit.service;

import br.com.warnit.model.domain.CategoriaDenuncia;
import br.com.warnit.repository.CategoriaDenunciaRepository;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoriaDenunciaService {
    @Autowired
    private CategoriaDenunciaRepository categoriaDenunciaRepository;

    public CategoriaDenuncia findById(Long id){
        Optional<CategoriaDenuncia> categoriaDenuncia = categoriaDenunciaRepository.findById(id);
        return categoriaDenuncia.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado. Id: "+ id+
                "Tipo: "+ CategoriaDenuncia.class.getSimpleName()));
    }
    @Transactional
    public CategoriaDenuncia save(CategoriaDenuncia categoriaDenuncia){
        return categoriaDenunciaRepository.save(categoriaDenuncia);
    }

}
