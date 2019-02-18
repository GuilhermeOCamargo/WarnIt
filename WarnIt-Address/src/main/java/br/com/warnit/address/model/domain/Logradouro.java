package br.com.warnit.address.model.domain;

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
	@JsonManagedReference
	@ManyToOne(optional=false, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "localidade_id")
	private Localidade localidade;
	@Column(length = 10, nullable = false)
	private String numero;
	@Column(length = 25, nullable = true)
	private String complemento;;
	
	public Logradouro(Long id, Localidade localidade, String numero, String complemento) {
		this.id = id;
		this.localidade = localidade;
		this.numero = numero;
		this.complemento = complemento;
	}
	public Logradouro() {}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Logradouro that = (Logradouro) o;
		return id.equals(that.id) &&
				localidade.equals(that.localidade) &&
				numero.equals(that.numero) &&
				complemento.equals(that.complemento);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, localidade, numero, complemento);
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
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
}