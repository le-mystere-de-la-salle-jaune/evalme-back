package dev.controller.api.viewModels.examen;

import dev.controller.api.viewModels.BaseVm;
import dev.entites.Examen;

public class ExamenNoteVm extends BaseVm {

	private String titre;
	private Float noteSur20;
	private Integer nbQuestions;

	public ExamenNoteVm(Examen examen, Long idStagiaire) {
		super(examen.getId());
		this.titre = examen.getTitre();
		this.noteSur20 = examen.getNotes().stream().filter(n -> n.getStagiaire().getId().equals(idStagiaire))
				.map(n -> n.getNoteSur20()).findFirst().get();
		this.nbQuestions = examen.getQuizz().getQuestions().size();
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
	 * @return the noteSur20
	 */
	public Float getNoteSur20() {
		return noteSur20;
	}

	/**
	 * @param noteSur20
	 *            the noteSur20 to set
	 */
	public void setNoteSur20(Float noteSur20) {
		this.noteSur20 = noteSur20;
	}

	/**
	 * @return the nbQuestions
	 */
	public Integer getNbQuestions() {
		return nbQuestions;
	}

	/**
	 * @param nbQuestions
	 *            the nbQuestions to set
	 */
	public void setNbQuestions(Integer nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

}
