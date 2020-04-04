package br.com.mosdev.apisiteviagem.validator;

import java.util.Optional;

import br.com.mosdev.apisiteviagem.model.Companhia;
import br.com.mosdev.apisiteviagem.model.CompanhiaForm;
import br.com.mosdev.apisiteviagem.repository.CompanhiaRepository;

public class NomeCompanhiaUnicoValidator extends CampoUnicoCompanhiaValidator{
	
	private CompanhiaRepository companhiaRepository;

	public NomeCompanhiaUnicoValidator(CompanhiaRepository companhiaRepository) {
		this.companhiaRepository = companhiaRepository;
	}
	

	@Override
	public Optional<Companhia> buscaCompanhiaPorCampo(CompanhiaForm form) {
		return companhiaRepository.findByNome(form.getNome());
	}

	@Override
	public String getCampoInvalido() {
		return "nome";
	}

}
