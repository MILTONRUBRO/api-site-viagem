package br.com.mosdev.apisiteviagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Aeroporto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@ManyToOne
	@NotNull
	private Pais pais;
	
	@Deprecated
	public Aeroporto() {
		
	}

	public Aeroporto(@NotNull @NotEmpty String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

}
