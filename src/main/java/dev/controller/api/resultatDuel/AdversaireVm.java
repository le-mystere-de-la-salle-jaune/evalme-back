package dev.controller.api.resultatDuel;

public class AdversaireVm {

	private Long id;
	private String nom;
	private String prenom;
	private Long score;

	public AdversaireVm() {
		super();
	}

	public AdversaireVm(Long id, String nom, String prenom, Long score) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.score = score;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the score
	 */
	public Long getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Long score) {
		this.score = score;
	}

}
