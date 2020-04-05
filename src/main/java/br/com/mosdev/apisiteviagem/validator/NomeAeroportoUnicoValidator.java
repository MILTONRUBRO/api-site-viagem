package br.com.mosdev.apisiteviagem.validator;

import java.util.Optional;

import br.com.mosdev.apisiteviagem.model.Aeroporto;
import br.com.mosdev.apisiteviagem.model.AeroportoForm;
import br.com.mosdev.apisiteviagem.repository.AeroportoRepository;

public class NomeAeroportoUnicoValidator extends CampoUnicoAeroportoValidator{
	
	private AeroportoRepository aeroportoRepository;
	
	public NomeAeroportoUnicoValidator(AeroportoRepository aeroportoRepository) {
		this.aeroportoRepository = aeroportoRepository;
	}

	@Override
	public Optional<Aeroporto> buscaAeroportoPorCampo(AeroportoForm form) {
		return aeroportoRepository.findByNome(form.getNome());
	}

	@Override
	public String getCampoInvalido() {
		return "nome";
	}

}
