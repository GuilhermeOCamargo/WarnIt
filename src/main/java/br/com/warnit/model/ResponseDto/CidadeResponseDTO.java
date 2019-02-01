package br.com.warnit.model.ResponseDto;

import br.com.warnit.model.domain.Cidade;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class CidadeResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private EstadoResponseDTO estado;

    public CidadeResponseDTO(Long id, String nome, EstadoResponseDTO estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }
    public CidadeResponseDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoResponseDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoResponseDTO estado) {
        this.estado = estado;
    }

    public static CidadeResponseDTO getDto(Cidade object) {
        return new CidadeResponseDTO(object.getId(), object.getNome(), EstadoResponseDTO.getDto(object.getEstado()));
    }
}
