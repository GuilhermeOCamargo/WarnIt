package br.com.warnit.service;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.model.domain.Usuario;
import br.com.warnit.model.dto.LogradouroDTO;
import br.com.warnit.repository.LogradouroRepository;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogradouroService {

    @Autowired
    private LogradouroRepository logradouroRepository;
    @Autowired
    private UsuarioService usuarioService;

    public Logradouro findById(Long id){
        Optional<Logradouro> logradouro = logradouroRepository.findById(id);
        return logradouro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id:"+id+
                "Tipo: "+ Logradouro.class.getSimpleName()));
    }

    public Logradouro save(Logradouro logradouro){
        return logradouroRepository.save(logradouro);
    }

    public Logradouro findByUsuario(Long usuarioId){
        Usuario usuario = usuarioService.findById(usuarioId);
        Optional<Logradouro> logradouro = logradouroRepository.findByUsuario(usuario);
        return logradouro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. UsuarioId:"+usuarioId+
                "Tipo: "+ Logradouro.class.getSimpleName()));
    }

    public Logradouro findOrPopulate(LogradouroDTO dto){
        Logradouro logradouro = null;
        try{
            if(dto.getIdLogradouro() != null){
                logradouro = findById(dto.getIdLogradouro());
            }else{
                logradouro = fromDto(dto);
            }
        }catch (ObjectNotFoundException e){
            logradouro = fromDto(dto);
        }
        return logradouro;
    }

    private Logradouro fromDto(LogradouroDTO dto){
        return new Logradouro(dto.getIdLogradouro(), dto.getNomeRua(), dto.getNumero(), dto.getComplemento(), dto.getCep());
    }
}
