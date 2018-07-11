package dev.entites;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Classe extends BaseEntite {

	@NotEmpty
	private String nom;

	@NotEmpty
	private List<Stagiaire> stagiaires = new ArrayList<>();

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
