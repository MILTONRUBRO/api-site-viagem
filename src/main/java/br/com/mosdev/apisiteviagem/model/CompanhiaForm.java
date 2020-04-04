package br.com.mosdev.apisiteviagem.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mosdev.apisiteviagem.repository.PaisRepository;

public class CompanhiaForm {
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	private Long idPais;
	
	public Companhia novaCompanhia(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(idPais).get();
		return new Companhia(nome, pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	
}
