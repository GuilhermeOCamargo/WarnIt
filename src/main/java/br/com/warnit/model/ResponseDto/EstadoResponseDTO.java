package br.com.warnit.model.ResponseDto;

import br.com.warnit.model.domain.Estado;

import java.io.Serializable;
/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class EstadoResponseDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeEstado;
    private String uf;

    public EstadoResponseDTO(Long id, String nomeEstado, String uf) {
        this.id = id;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
    }
    public EstadoResponseDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public static EstadoResponseDTO getDto(Estado object) {
        return new EstadoResponseDTO(object.getId(), object.getNomeEstado(), object.getUf());
    }
}
