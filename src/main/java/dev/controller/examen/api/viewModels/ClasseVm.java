package dev.controller.examen.api.viewModels;

import dev.controller.BaseVm;

public class ClasseVm extends BaseVm {

	private String nom;

	public ClasseVm(Long id, String nom) {
		super(id);
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
