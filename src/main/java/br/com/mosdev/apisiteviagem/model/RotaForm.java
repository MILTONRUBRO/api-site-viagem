package br.com.mosdev.apisiteviagem.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.mosdev.apisiteviagem.repository.AeroportoRepository;

public class RotaForm {

	private String nome;

	@NotNull
	private Long idAeroportoOrigem;

	@NotNull
	private Long idAeroportoDestino;

	@NotNull
	@Positive
	private int duracao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdAeroportoOrigem() {
		return idAeroportoOrigem;
	}

	public void setIdAeroportoOrigem(Long idAeroportoOrigem) {
		this.idAeroportoOrigem = idAeroportoOrigem;
	}

	public Long getIdAeroportoDestino() {
		return idAeroportoDestino;
	}

	public void setIdAeroportoDestino(Long idAeroportoDestino) {
		this.idAeroportoDestino = idAeroportoDestino;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Rota nova(AeroportoRepository aeroportoRepository) {

		Aeroporto aeroportoOrigem = aeroportoRepository.findById(idAeroportoOrigem).get();
		Aeroporto aeroportoDestino = aeroportoRepository.findById(idAeroportoDestino).get();

		if (nome == null || nome.isEmpty()) {
			nome = aeroportoOrigem.getNome() + " - " + aeroportoDestino.getNome();
		}

		return new Rota(nome, aeroportoOrigem, aeroportoDestino, duracao);

	}

}
