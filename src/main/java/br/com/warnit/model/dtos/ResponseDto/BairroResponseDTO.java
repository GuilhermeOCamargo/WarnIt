package br.com.warnit.model.dtos.ResponseDto;

import br.com.warnit.model.domain.Bairro;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class BairroResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private CidadeResponseDTO cidade;

    public BairroResponseDTO(Long id, String nome, CidadeResponseDTO cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public BairroResponseDTO() {}

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

    public CidadeResponseDTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeResponseDTO cidade) {
        this.cidade = cidade;
    }

    public static BairroResponseDTO getDto(Bairro object) {
        return new BairroResponseDTO(object.getId(), object.getNome(), CidadeResponseDTO.getDto(object.getCidade()));
    }
}
