package dev.controller.api.viewModels.examen;

public class ExamenReponseVm {
	private Long idStagiaire;
	private Long idExamen;
	private Long idQuestion;
	private Long idOptionQuestion;

	public ExamenReponseVm(Long idStagiaire, Long idExamen, Long idQuestion, Long idOptionQuestion) {
		super();
		this.idStagiaire = idStagiaire;
		this.idExamen = idExamen;
		this.idQuestion = idQuestion;
		this.idOptionQuestion = idOptionQuestion;
	}

	public ExamenReponseVm() {

	}

	public Long getIdStagiaire() {
		return idStagiaire;
	}

	public void setIdStagiaire(Long idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public Long getIdOptionQuestion() {
		return idOptionQuestion;
	}

	public void setIdOptionQuestion(Long idOptionQuestion) {
		this.idOptionQuestion = idOptionQuestion;
	}

}
