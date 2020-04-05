package br.com.mosdev.apisiteviagem.model;

public class AeroportoPaisDTO extends Pais {

	private Long id;
	private String nome;

	public AeroportoPaisDTO(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
