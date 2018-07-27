package dev.controller.api.viewModels.examen;

public class OptionQuestionVm {

	private Long id;
	private String libelle;

	public OptionQuestionVm(Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
