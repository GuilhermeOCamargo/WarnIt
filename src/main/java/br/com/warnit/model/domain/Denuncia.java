package br.com.warnit.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * @author Guilherme Camargo
 * @since 05/02/2019
 * @version 1.0
 * */
@Entity
public class Denuncia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Localidade localidade;
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private CategoriaDenuncia categoria;
    @Column(nullable = false, length = 500)
    private String detalhes;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHora;
    @Column(nullable = true, length = 255)
    private String filePath;

    public Denuncia(Long id, Localidade localidade, CategoriaDenuncia categoria, String detalhes, Calendar dataHora, String filePath) {
        this.id = id;
        this.localidade = localidade;
        this.categoria = categoria;
        this.detalhes = detalhes;
        this.dataHora = dataHora;
        this.filePath = filePath;
    }
    public Denuncia(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Denuncia denuncia = (Denuncia) o;
        return id.equals(denuncia.id) &&
                localidade.equals(denuncia.localidade) &&
                categoria.equals(denuncia.categoria) &&
                detalhes.equals(denuncia.detalhes) &&
                dataHora.equals(denuncia.dataHora) &&
                filePath.equals(denuncia.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localidade, categoria, detalhes, dataHora, filePath);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public CategoriaDenuncia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDenuncia categoria) {
        this.categoria = categoria;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
