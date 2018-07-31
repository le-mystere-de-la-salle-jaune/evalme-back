package dev.controller.api.resultatsDuels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultatDuelVm {

	Long id;
	@JsonProperty("titre_quizz")
	String titreQuizz;
	AdversaireVm adversaire;
	Long score;

	public ResultatDuelVm() {
		super();
	}

	public ResultatDuelVm(Long id, String titreQuizz, AdversaireVm adversaire, Long score) {
		super();
		this.id = id;
		this.titreQuizz = titreQuizz;
		this.adversaire = adversaire;
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
	 * @return the titreQuizz
	 */
	public String getTitreQuizz() {
		return titreQuizz;
	}

	/**
	 * @param titreQuizz
	 *            the titreQuizz to set
	 */
	public void setTitreQuizz(String titreQuizz) {
		this.titreQuizz = titreQuizz;
	}

	/**
	 * @return the adversaire
	 */
	public AdversaireVm getAdversaire() {
		return adversaire;
	}

	/**
	 * @param adversaire
	 *            the adversaire to set
	 */
	public void setAdversaire(AdversaireVm adversaire) {
		this.adversaire = adversaire;
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
