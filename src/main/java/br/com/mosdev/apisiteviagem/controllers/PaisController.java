package br.com.mosdev.apisiteviagem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.apisiteviagem.model.Pais;
import br.com.mosdev.apisiteviagem.model.PaisForm;
import br.com.mosdev.apisiteviagem.repository.PaisRepository;

@RestController
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping(value="api/pais")
	public void cadastrar(@Valid @RequestBody PaisForm form) {
		
		Pais pais = form.novoPais();
		
		paisRepository.save(pais);
	}
}
