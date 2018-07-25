package dev.controller.quizz.api.viewModels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.controller.BaseVm;
import dev.controller.quizz.api.QuizzVmUtils;
import dev.entites.Quizz;

public class QuizzVm extends BaseVm {

	@JsonProperty("titre")
	private String titre;
	@JsonProperty("nb_questions")
	private int nbQuestion;
	@JsonProperty("questions")
	private List<QuestionVm> questions;

	public QuizzVm() {
		super();
	}

	public QuizzVm(Quizz quizz) {
		super(quizz.getId());
		this.titre = quizz.getTitre();
		this.nbQuestion = quizz.getQuestions().size();
		this.questions = QuizzVmUtils.getQuestionsVm(quizz.getQuestions());
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbQuestion() {
		return nbQuestion;
	}

	public List<QuestionVm> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<QuestionVm> questions) {
		this.questions = questions;
		this.nbQuestion = questions.size();
	}

}
