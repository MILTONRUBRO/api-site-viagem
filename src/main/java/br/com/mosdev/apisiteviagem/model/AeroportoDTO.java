package br.com.mosdev.apisiteviagem.model;

import java.util.List;
import java.util.stream.Collectors;

public class AeroportoDTO {

	private Long id;
	private String nome;
	private Pais pais;

	public AeroportoDTO(Aeroporto aeroporto) {
		this.id = aeroporto.getId();
		this.nome = aeroporto.getNome();
		this.pais = new AeroportoPaisDTO(aeroporto.getPais());

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public static List<AeroportoDTO> converter(List<Aeroporto> aeroportos) {
		return aeroportos.stream().map(AeroportoDTO::new).collect(Collectors.toList());
	}

}
