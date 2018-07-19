package dev.controller.api.questions.viewModels;

import java.util.List;

import dev.entites.OptionQuestion;

public class ListerQuestionVM {

	private long id;
	private String titre;
	private List<OptionQuestion> questions;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the questions
	 */
	public List<OptionQuestion> getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(List<OptionQuestion> questions) {
		this.questions = questions;
	}

}
