package dev.controller.api.questions.viewModels;

public class ListerQuestionVM {

	private long id;
	private String titre;
	private int nb_option;

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
	 * @return the nb_option
	 */
	public int getNb_option() {
		return nb_option;
	}

	/**
	 * @param nb_option
	 *            the nb_option to set
	 */
	public void setNb_option(int nb_option) {
		this.nb_option = nb_option;
	}

}
