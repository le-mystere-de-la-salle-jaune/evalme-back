package dev.controller.quizz.api.viewModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.controller.BaseVm;
import dev.entites.Question;

public class QuestionVm extends BaseVm {

	@JsonProperty("titre")
	private String titre;

	public QuestionVm() {
		super();
	}

	public QuestionVm(Question question) {
		super(question.getId());
		this.titre = question.getTitre();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
