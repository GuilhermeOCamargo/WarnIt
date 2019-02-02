package br.com.warnit.model.dtos.ResponseDto;

import br.com.warnit.model.domain.Rua;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class RuaResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeRua;
    private BairroResponseDTO bairro;
    private String cep;

    public RuaResponseDTO(Long id, String nomeRua, BairroResponseDTO bairro, String cep) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.cep = cep;
    }

    public RuaResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public BairroResponseDTO getBairro() {
        return bairro;
    }

    public void setBairro(BairroResponseDTO bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public static RuaResponseDTO getDto(Rua object) {
        return new RuaResponseDTO(object.getId(), object.getNomeRua(), BairroResponseDTO.getDto(object.getBairro()), object.getCep());
    }
}
