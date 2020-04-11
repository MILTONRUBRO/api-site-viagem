package br.com.mosdev.apisiteviagem.validator;

import java.util.Optional;

import br.com.mosdev.apisiteviagem.model.Rota;
import br.com.mosdev.apisiteviagem.model.RotaForm;
import br.com.mosdev.apisiteviagem.repository.RotaRepository;

public class OrigemDestinoRotaUnicoValidator extends CampoUnicoRotaOrigemDestino{
	
	private RotaRepository rotaRepository;
	
	public OrigemDestinoRotaUnicoValidator(RotaRepository rotaRepository) {
		this.rotaRepository = rotaRepository;
	}

	@Override
	public Optional<Rota> buscaRotaPorCampo(RotaForm form) {
		return rotaRepository.findByOrigemDestino(form.getIdAeroportoOrigem(), form.getIdAeroportoDestino());
	}

	@Override
	public String getCampoInvalido() {
		return "idAeroportoOrigem";
	}

}
