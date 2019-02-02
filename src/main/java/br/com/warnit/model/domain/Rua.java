package br.com.warnit.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Rua implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25, nullable = false, unique = true)
    private String nomeRua;
    @JsonManagedReference
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "bairro_id", nullable = false)
    private Bairro bairro;
    @Column(length=8, nullable=false, unique = true)
    private String cep;
    @JsonBackReference
    @OneToMany
    private List<Logradouro> logradouros = new ArrayList<>();

    public Rua(Long id, String nomeRua, Bairro bairro, String cep) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.cep = cep;
    }
    public Rua() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rua rua1 = (Rua) o;
        return Objects.equals(id, rua1.id) &&
                Objects.equals(nomeRua, rua1.nomeRua) &&
                Objects.equals(bairro, rua1.bairro) &&
                Objects.equals(cep, rua1.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeRua, bairro, cep);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
