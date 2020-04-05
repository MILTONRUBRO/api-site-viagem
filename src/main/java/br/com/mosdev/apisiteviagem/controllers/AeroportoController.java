package br.com.mosdev.apisiteviagem.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.apisiteviagem.errors.ResourceNotFoundException;
import br.com.mosdev.apisiteviagem.model.Aeroporto;
import br.com.mosdev.apisiteviagem.model.AeroportoDTO;
import br.com.mosdev.apisiteviagem.model.AeroportoForm;
import br.com.mosdev.apisiteviagem.repository.AeroportoRepository;
import br.com.mosdev.apisiteviagem.repository.PaisRepository;
import br.com.mosdev.apisiteviagem.validator.NomeAeroportoUnicoValidator;

@RestController
public class AeroportoController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@InitBinder("aeroportoForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new NomeAeroportoUnicoValidator(aeroportoRepository));
		
	}

	@PostMapping(value="api/aeroporto")
	@Transactional
	public void novo(@Valid @RequestBody AeroportoForm form) {
		Aeroporto aeroporto = form.novoAeroporto(paisRepository);
		aeroportoRepository.save(aeroporto);
	}
	
	@GetMapping(value="api/aeroportos")
	public List<AeroportoDTO> listar(){
		
		List<Aeroporto> aeroportos = aeroportoRepository.findAll();
		
		return AeroportoDTO.converter(aeroportos);
	}
	
	@GetMapping(value="api/aeroporto/{idAeroporto}")
	public AeroportoDTO getAeroporto(@PathVariable Long idAeroporto) {
		Aeroporto aeroporto = aeroportoRepository.findById(idAeroporto).orElseThrow(() -> new ResourceNotFoundException());
		
		return new AeroportoDTO(aeroporto);
	}
 
}
