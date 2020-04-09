package br.com.mosdev.apisiteviagem.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosdev.apisiteviagem.model.Rota;
import br.com.mosdev.apisiteviagem.model.RotaForm;

public abstract class CampoUnicoRotaOrigemDestino implements  Validator{
	
	public abstract Optional<Rota> buscaRotaPorCampo(RotaForm form);

	@Override
	public boolean supports(Class<?> arg0) {
		return RotaForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RotaForm form = (RotaForm) target;
		Optional<Rota> possivelRota = buscaRotaPorCampo(form);

		if (possivelRota.isPresent()) {
			String campoInvalido = getCampoInvalido();
			errors.rejectValue(campoInvalido, null,  campoInvalido + " Campo ja existente no banco de dados" );
		}
	}
	
	public abstract String getCampoInvalido();

}
