package br.com.mosdev.apisiteviagem.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosdev.apisiteviagem.model.Aeroporto;
import br.com.mosdev.apisiteviagem.model.AeroportoForm;

public abstract class CampoUnicoAeroportoValidator implements Validator{

	public abstract Optional<Aeroporto> buscaAeroportoPorCampo(AeroportoForm form);

	@Override
	public boolean supports(Class<?> arg0) {
		return AeroportoForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AeroportoForm form = (AeroportoForm) target;
		Optional<Aeroporto> possivelAeroporto = buscaAeroportoPorCampo(form);

		if (possivelAeroporto.isPresent()) {
			String campoInvalido = getCampoInvalido();
			errors.rejectValue(campoInvalido, null,  campoInvalido + " Campo ja existente no banco de dados" );
		}
	}
	
	public abstract String getCampoInvalido();


}
