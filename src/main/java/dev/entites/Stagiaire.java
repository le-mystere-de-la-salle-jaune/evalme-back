package dev.entites;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Stagiaire extends BaseEntite {

	@Size(min = 2)
	private String prenom;
	@Size(min = 2)
	private String nom;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String photoUrl;

	public Stagiaire() {
	}

	public Stagiaire(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Stagiaire(String prenom, String nom, String email, String photoUrl) {
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

}
