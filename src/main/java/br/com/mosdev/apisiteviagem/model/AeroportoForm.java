package br.com.mosdev.apisiteviagem.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mosdev.apisiteviagem.repository.PaisRepository;

public class AeroportoForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	private Long idPais;

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

	public Aeroporto novoAeroporto(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(idPais).get();

		return new Aeroporto(nome, pais);
	}

}
