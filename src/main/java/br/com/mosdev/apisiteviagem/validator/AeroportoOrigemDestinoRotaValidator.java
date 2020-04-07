package br.com.mosdev.apisiteviagem.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosdev.apisiteviagem.model.Rota;
import br.com.mosdev.apisiteviagem.model.RotaForm;
import br.com.mosdev.apisiteviagem.repository.RotaRepository;

public class AeroportoOrigemDestinoRotaValidator implements Validator{

	RotaRepository rotaRepository;


	public AeroportoOrigemDestinoRotaValidator(RotaRepository rotaRepository) {
		this.rotaRepository = rotaRepository;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return RotaForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RotaForm form = (RotaForm) target;
		
		List<Rota> rotas = rotaRepository.findAll();
		
        boolean found = rotas.stream()
        		.anyMatch(r-> r.getAeroportoOrigem().getId()
        		.equals(form.getIdAeroportoOrigem()) && r.getAeroportoDestino().getId()
        		.equals(form.getIdAeroportoDestino()));

		
		
		if(rotas.size() > 0 && found) {
			errors.rejectValue("idAeroportoOrigem", null, "Uma origem e destino igual já está cadastrado.");
		}
	}

}
