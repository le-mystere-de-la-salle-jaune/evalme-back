package dev.controller.api.viewModels.classe;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.entites.Classe;
import dev.entites.Stagiaire;

public class ClasseVmLister extends BaseVm {

	private String nom;
	@JsonIgnore
	private List<Stagiaire> stagiaires = new ArrayList<>();

	public ClasseVmLister() {
		super();
	}

	public ClasseVmLister(String nom, List<Stagiaire> stagiaires) {
		super();
		this.nom = nom;
		this.stagiaires = stagiaires;
	}

	public ClasseVmLister(Classe c) {
		super(c.getId());
		this.nom = c.getNom();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

}
