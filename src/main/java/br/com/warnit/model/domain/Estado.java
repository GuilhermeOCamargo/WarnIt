package br.com.warnit.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@Entity
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25, nullable = false)
    private String nomeEstado;
    @Column(length = 2, nullable = false)
    private String uf;
    @JsonBackReference
    @OneToMany
    private List<Cidade> cidades = new ArrayList<>();

    public Estado(String nomeEstado, String uf) {
        this.nomeEstado = nomeEstado;
        this.uf = uf;
    }
    public Estado() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id.equals(estado.id) &&
                nomeEstado.equals(estado.nomeEstado) &&
                uf.equals(estado.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeEstado, uf);
    }

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

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
