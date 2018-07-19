package dev.controller.api.questions.viewModels;

import java.util.List;

import dev.entites.OptionQuestion;

public class ListerQuestionVM {

	private long id;
	private String titre;
	private List<OptionQuestion> options;

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
	public List<OptionQuestion> getOptions() {
		return options;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setOptions(List<OptionQuestion> options) {
		this.options = options;
	}

}
