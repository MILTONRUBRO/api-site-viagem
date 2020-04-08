package br.com.mosdev.apisiteviagem.model;

import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.mosdev.apisiteviagem.errors.ResourceDuplicatedException;
import br.com.mosdev.apisiteviagem.repository.AeroportoRepository;
import br.com.mosdev.apisiteviagem.repository.RotaRepository;

public class RotaForm {

	private String nome;

	@NotNull
	private Long idAeroportoOrigem;

	@NotNull
	private Long idAeroportoDestino;

	@NotNull
	@Min(value=1)
	private Integer duracao;

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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Rota nova(AeroportoRepository aeroportoRepository, RotaRepository rotaRepository) {

		Aeroporto aeroportoOrigem = aeroportoRepository.findById(idAeroportoOrigem).get();
		Aeroporto aeroportoDestino = aeroportoRepository.findById(idAeroportoDestino).get();
		
		//verifica se já existe uma origem e destino cadastrado
		Optional<Rota> possivelRota = rotaRepository.findByOrigemDestino(idAeroportoOrigem, idAeroportoDestino);
		
		
		
		if(idAeroportoOrigem ==  idAeroportoDestino || possivelRota.isPresent()) {
			throw new ResourceDuplicatedException();
		}

		if (nome == null || nome.isEmpty()) {
			//nome = aeroportoOrigem.getNome() + " - " + aeroportoDestino.getNome();
			return new Rota(aeroportoOrigem, aeroportoDestino, duracao);
			
		}

		return new Rota(nome, aeroportoOrigem, aeroportoDestino, duracao);

	}

}
