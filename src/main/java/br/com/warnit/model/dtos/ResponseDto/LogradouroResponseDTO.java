package br.com.warnit.model.dtos.ResponseDto;

import br.com.warnit.model.domain.Logradouro;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class LogradouroResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private RuaResponseDTO rua;
    private String numero;
    private String complemento;

    public LogradouroResponseDTO(Long id, RuaResponseDTO rua, String numero, String complemento) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public LogradouroResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RuaResponseDTO getRua() {
        return rua;
    }

    public void setRua(RuaResponseDTO rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public static LogradouroResponseDTO getDto(Logradouro object) {
        return new LogradouroResponseDTO(object.getId(), RuaResponseDTO.getDto(object.getRua()), object.getNumero(), object.getComplemento());
    }
}
