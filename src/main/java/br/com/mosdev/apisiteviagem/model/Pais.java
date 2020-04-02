package br.com.mosdev.apisiteviagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {
	

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Pais(@NotNull @NotEmpty String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	

}
