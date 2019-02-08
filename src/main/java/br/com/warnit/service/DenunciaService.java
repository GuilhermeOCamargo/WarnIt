package br.com.warnit.service;

import br.com.warnit.model.domain.CategoriaDenuncia;
import br.com.warnit.model.domain.Denuncia;
import br.com.warnit.model.domain.Localidade;
import br.com.warnit.model.dto.DenunciaDTO;
import br.com.warnit.model.dto.LocalidadeDTO;
import br.com.warnit.repository.DenunciaRepository;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
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
    private LocalidadeService localidadeService;
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
        LocalidadeDTO localidadeDTO = new LocalidadeDTO(dto.getIdLocalidade(), dto.getNomeLocalidade(),
                dto.getCep(), dto.getIdBairro(), dto.getNomeBairro(), dto.getIdCidade(), dto.getNomeCidade(), dto.getIdEstado(),
                dto.getNomeEstado(), dto.getUf());
        CategoriaDenuncia categoriaDenuncia;
        Localidade localidade = localidadeService.fromDto(localidadeDTO);
        if(localidade.getId() == null){
            localidade = localidadeService.save(localidade);
        }
        if(dto.getIdCategoria() != null){
            categoriaDenuncia = categoriaDenunciaService.findById(dto.getIdCategoria());
        }else{
            categoriaDenuncia = new CategoriaDenuncia(null, dto.getNomeCategoria());
            categoriaDenuncia = categoriaDenunciaService.save(categoriaDenuncia);
        }

        Denuncia denuncia = new Denuncia(null, localidade, categoriaDenuncia, dto.getDetalhes(), Calendar.getInstance(), "FakePath");

        return denuncia;
    }
}
