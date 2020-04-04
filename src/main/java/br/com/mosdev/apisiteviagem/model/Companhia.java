package br.com.mosdev.apisiteviagem.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Companhia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nome;

	@PastOrPresent
	private LocalDateTime instanteCriacao;

	@NotNull
	@ManyToOne
	private Pais pais;

	@Deprecated
	public Companhia() {

	}

	public Companhia(@NotNull @NotEmpty String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
		instanteCriacao = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public Pais getPais() {
		return pais;
	}

}
