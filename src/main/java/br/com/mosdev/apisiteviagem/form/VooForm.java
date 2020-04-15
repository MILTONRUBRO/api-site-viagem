package br.com.mosdev.apisiteviagem.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.mosdev.apisiteviagem.model.Rota;
import br.com.mosdev.apisiteviagem.model.Voo;
import br.com.mosdev.apisiteviagem.repository.RotaRepository;

public class VooForm {

	@NotNull
	@Positive
	private Integer lugaresDisponiveis;

	private String nomeRota;

	public Integer getLugaresDisponiveis() {
		return lugaresDisponiveis;
	}

	public void setLugaresDisponiveis(Integer lugaresDisponiveis) {
		this.lugaresDisponiveis = lugaresDisponiveis;
	}

	public String getNomeRota() {
		return nomeRota;
	}

	public void setNomeRota(String nomeRota) {
		this.nomeRota = nomeRota;
	}

	public Voo novo(RotaRepository rotaRepository) {

		List<Rota> rotas = rotaRepository.findBynomeRotas(nomeRota);

		return new Voo(rotas, lugaresDisponiveis);
	}

}
