package br.com.mosdev.apisiteviagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
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
	
	private @NotNull @Positive Integer duracao;
	
	private String escalaConexao;
	
	@Min(value=1)
	private Integer tempoParada;
	
	@Deprecated
	public Rota() {
		
	}

	public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, @NotNull @Positive int duracao) {
		this.nome= nome;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.duracao = duracao;
	}

	public Rota(Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, @NotNull @Min(1) Integer duracao) {
		this.nome = aeroportoOrigem.getNome() +  " - "  + aeroportoDestino.getNome();
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.duracao = duracao;
	}

	public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino,
			@NotNull @Min(1) Integer duracao, String escalaConexao) {
		
		this.nome= nome;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.duracao = duracao;
		this.escalaConexao = escalaConexao;
		this.tempoParada = (Integer)duracao/4;
	}

	public Rota(Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, @NotNull @Min(1) Integer duracao,
			String escalaConexao) {
		
		this.nome = aeroportoOrigem.getNome() +  " - "  + aeroportoDestino.getNome();
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.duracao = duracao;
		this.escalaConexao = escalaConexao;
		this.tempoParada = (Integer)duracao/4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroportoDestino == null) ? 0 : aeroportoDestino.hashCode());
		result = prime * result + ((aeroportoOrigem == null) ? 0 : aeroportoOrigem.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
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
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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

	public Integer getDuracao() {
		return duracao;
	}
	
}
