package br.com.warnit.denuncia.service;

import br.com.warnit.denuncia.service.exceptions.ObjectNotFoundException;
import br.com.warnit.denuncia.model.domain.CategoriaDenuncia;
import br.com.warnit.denuncia.model.domain.Denuncia;
import br.com.warnit.denuncia.model.dto.DenunciaDTO;
import br.com.warnit.denuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Optional;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;
    @Autowired
    private CategoriaDenunciaService categoriaDenunciaService;

    public Denuncia findById(Long id){
        Optional<Denuncia> denuncia = denunciaRepository.findById(id);
        return denuncia.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: "+ id +
                "Tipo: "+ Denuncia.class.getSimpleName()));
    }
    @Transactional
    public Denuncia save(Denuncia denuncia){
        return denunciaRepository.save(denuncia);
    }

    /** Convert a {@link DenunciaDTO} in a {@link Denuncia}
     * @param dto
     * @return Denuncia
     * */
    public Denuncia fromDto(DenunciaDTO dto){
        CategoriaDenuncia categoriaDenuncia;
        if(dto.getIdCategoria() != null){
            categoriaDenuncia = categoriaDenunciaService.findById(dto.getIdCategoria());
        }else{
            categoriaDenuncia = new CategoriaDenuncia(null, dto.getNomeCategoria());
            categoriaDenuncia = categoriaDenunciaService.save(categoriaDenuncia);
        }

        Denuncia denuncia = new Denuncia(null, null, categoriaDenuncia, dto.getDetalhes(), Calendar.getInstance(), "FakePath");

        return denuncia;
    }
}
