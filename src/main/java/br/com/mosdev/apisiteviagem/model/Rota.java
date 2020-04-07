package br.com.mosdev.apisiteviagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Rota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToOne
	private Aeroporto aeroportoOrigem;
	
	@ManyToOne
	private Aeroporto aeroportoDestino;
	
	private @NotNull @Positive int duracao;
	
	@Deprecated
	public Rota() {
		
	}

	public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, @NotNull @Positive int duracao) {
		this.nome= nome;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.duracao = duracao;
	}

	public String getNome() {
		return nome;
	}

	public Aeroporto getAeroportoOrigem() {
		return aeroportoOrigem;
	}

	public Aeroporto getAeroportoDestino() {
		return aeroportoDestino;
	}

	public int getDuracao() {
		return duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroportoDestino == null) ? 0 : aeroportoDestino.hashCode());
		result = prime * result + ((aeroportoOrigem == null) ? 0 : aeroportoOrigem.hashCode());
		result = prime * result + duracao;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rota other = (Rota) obj;
		if (aeroportoDestino == null) {
			if (other.aeroportoDestino != null)
				return false;
		} else if (!aeroportoDestino.equals(other.aeroportoDestino))
			return false;
		if (aeroportoOrigem == null) {
			if (other.aeroportoOrigem != null)
				return false;
		} else if (!aeroportoOrigem.equals(other.aeroportoOrigem))
			return false;
		if (duracao != other.duracao)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	

}
