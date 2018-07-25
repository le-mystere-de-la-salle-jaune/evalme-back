package dev.controller.api.questions.viewModels;

import java.util.List;

public class QuestionByIdVM {

	private long id;
	private String titre;
	private List<OptionListerQuestionVM> options;

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
	 * @return the options
	 */
	public List<OptionListerQuestionVM> getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(List<OptionListerQuestionVM> options) {
		this.options = options;
	}

}
