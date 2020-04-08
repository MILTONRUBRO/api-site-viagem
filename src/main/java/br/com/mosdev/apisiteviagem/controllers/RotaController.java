package br.com.mosdev.apisiteviagem.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.apisiteviagem.model.Rota;
import br.com.mosdev.apisiteviagem.model.RotaForm;
import br.com.mosdev.apisiteviagem.repository.AeroportoRepository;
import br.com.mosdev.apisiteviagem.repository.RotaRepository;

@RestController
public class RotaController {
	
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@PostMapping("api/rota")
	@Transactional
	public void nova(@Valid @RequestBody RotaForm form) {
		Rota rota = form.nova(aeroportoRepository, rotaRepository);
		rotaRepository.save(rota);
	}

}
