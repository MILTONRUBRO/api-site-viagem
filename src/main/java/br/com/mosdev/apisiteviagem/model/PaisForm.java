package br.com.mosdev.apisiteviagem.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaisForm {
	
	@NotNull
	@NotEmpty
	private String nome;

	public Pais novoPais() {
		return new Pais(nome);
	}

	public String getNome() {
		return nome;
	}
}
