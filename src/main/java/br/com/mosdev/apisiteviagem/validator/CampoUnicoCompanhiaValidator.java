package br.com.mosdev.apisiteviagem.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosdev.apisiteviagem.model.Companhia;
import br.com.mosdev.apisiteviagem.model.CompanhiaForm;

public abstract class CampoUnicoCompanhiaValidator implements Validator {


	public abstract Optional<Companhia> buscaCompanhiaPorCampo(CompanhiaForm form);

	@Override
	public boolean supports(Class<?> arg0) {
		return CompanhiaForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CompanhiaForm form = (CompanhiaForm) target;
		Optional<Companhia> possivelCompanhia = buscaCompanhiaPorCampo(form);

		if (possivelCompanhia.isPresent()) {
			String campoInvalido = getCampoInvalido();
			errors.rejectValue(campoInvalido, null,  campoInvalido + " Campo ja existente no banco de dados" );
		}
	}
	
	public abstract String getCampoInvalido();

}
