package br.com.mosdev.apisiteviagem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Voo {
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@OneToMany(targetEntity = Rota.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rota> rotas;
	
	@NotNull
	@Positive
	private Integer lugaresDisponiveis;
	
	public Voo(List<Rota> rotas, @NotNull @Positive Integer lugaresDisponiveis) {
		this.rotas = rotas;
		this.lugaresDisponiveis = lugaresDisponiveis;
	}

 
}
