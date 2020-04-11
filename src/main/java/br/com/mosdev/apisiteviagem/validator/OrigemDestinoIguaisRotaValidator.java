package br.com.mosdev.apisiteviagem.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosdev.apisiteviagem.model.RotaForm;

public class OrigemDestinoIguaisRotaValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RotaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RotaForm form = (RotaForm) target;

		if(form.comparaRotas()){
			errors.rejectValue("idAeroportoOrigem", null, "A rota de origem não pode ser a mesma de destino ");
		}
		
	}

}
