package br.com.warnit.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@Entity
public class Logradouro implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25, nullable = false, unique = true)
    private String nomeRua;
    @Column(length = 10, nullable = false)
    private String numero;
    @Column(length = 25, nullable = true)
    private String complemento;;
    @Column(length=8, nullable=false, unique = true)
    private String cep;
    @OneToOne
    private Usuario usuario;

    public Logradouro(Long id, String nomeRua, String numero, String complemento, String cep) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }
    public Logradouro() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logradouro that = (Logradouro) o;
        return id.equals(that.id) &&
                nomeRua.equals(that.nomeRua) &&
                numero.equals(that.numero) &&
                Objects.equals(complemento, that.complemento) &&
                cep.equals(that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeRua, numero, complemento, cep);
    }

    //Getters And Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() { return complemento;}
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getNomeRua() {
        return nomeRua;
    }
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
