package br.com.warnit.model.domain;

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
	@ManyToOne(optional=false, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "rua_id")
	private Rua rua;
	@Column(length = 10, nullable = false)
	private String numero;
	@Column(length = 25, nullable = true)
	private String complemento;
	
	public Logradouro(Long id, Rua rua, String numero, Bairro bairro, String complemento, String cep) {
		super();
		this.id = id;
		this.rua = rua;
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
				rua.equals(that.rua) &&
				numero.equals(that.numero) &&
				complemento.equals(that.complemento);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rua, numero, complemento);
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

	public Rua getRua() {
		return rua;
	}

	public void setRua(Rua rua) {
		this.rua = rua;
	}
}