package dev.controller.api.viewModels.classe;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.entites.Classe;

public class StagiaireVmDetail extends BaseVm {

	private String prenom;
	private String nom;
	private String email;
	private String photoUrl;

	@JsonIgnore
	private Classe classe;

	public StagiaireVmDetail() {
	}

	public StagiaireVmDetail(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public StagiaireVmDetail(String prenom, String nom, String email, String photoUrl) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.photoUrl = photoUrl;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * @param classe
	 *            the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
