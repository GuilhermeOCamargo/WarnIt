package br.com.warnit.denuncia.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Guilherme Camargo
 * @since 05/02/2019
 * @version 1.0
 * */
@Entity
public class CategoriaDenuncia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 30)
    private String nome;
    @JsonBackReference
    @OneToMany(mappedBy = "categoria")
    private List<Denuncia> denuncias = new ArrayList<>();

    public CategoriaDenuncia(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDenuncia(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaDenuncia that = (CategoriaDenuncia) o;
        return id.equals(that.id) &&
                nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

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
}
