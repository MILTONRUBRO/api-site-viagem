package br.com.mosdev.apisiteviagem.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.apisiteviagem.form.VooForm;
import br.com.mosdev.apisiteviagem.model.Voo;
import br.com.mosdev.apisiteviagem.repository.RotaRepository;
import br.com.mosdev.apisiteviagem.repository.VooRepository;

@RestController
public class VooController {
	
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private VooRepository vooRepository;
	
	@PostMapping("api/voo")
	@Transactional
	public void novo(@Valid @RequestBody VooForm form) {
		Voo voo = form.novo(rotaRepository);
		
		vooRepository.save(voo);
	}
	

}
