package br.com.mosdev.apisiteviagem.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.apisiteviagem.model.Companhia;
import br.com.mosdev.apisiteviagem.model.CompanhiaForm;
import br.com.mosdev.apisiteviagem.repository.CompanhiaRepository;
import br.com.mosdev.apisiteviagem.repository.PaisRepository;
import br.com.mosdev.apisiteviagem.validator.NomeCompanhiaUnicoValidator;

@RestController
public class CompanhiaController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private CompanhiaRepository companhiaRepository;
	
	@InitBinder("companhiaForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new NomeCompanhiaUnicoValidator(companhiaRepository));
		
	}

	@PostMapping(value="api/companhia")
	@Transactional
	public void nova(@Valid @RequestBody CompanhiaForm form) {
		
		Companhia companhia = form.novaCompanhia(paisRepository);
		
		companhiaRepository.save(companhia);
		
	}

}
