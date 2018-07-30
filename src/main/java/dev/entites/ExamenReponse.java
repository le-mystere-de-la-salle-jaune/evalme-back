package dev.entites;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reponse_examen")
public class ExamenReponse extends BaseEntite {

	@ManyToOne
	@JoinColumn(name = "id_stagiaire")
	private Stagiaire stagiaire;
	@ManyToOne
	@JoinColumn(name = "id_examen")
	private Examen examen;
	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;
	@ManyToOne
	@JoinColumn(name = "id_option_question")
	private OptionQuestion optionQuestion;

	public ExamenReponse() {

	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public OptionQuestion getOptionQuestion() {
		return optionQuestion;
	}

	public void setOptionQuestion(OptionQuestion optionQuestion) {
		this.optionQuestion = optionQuestion;
	}

}
