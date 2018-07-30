package dev.controller.api.questions.viewModels;

import java.util.List;
import java.util.stream.Collectors;

import dev.controller.api.viewModels.BaseVm;
import dev.entites.Question;

public class QuestionPassageConcoursVm extends BaseVm{
	
	private String libelle;
	private List<OptionQuestionNeutreVm> optionsReponse;
	
	public QuestionPassageConcoursVm(Question uneQuestion) {
		super(uneQuestion.getId());
		libelle = uneQuestion.getTitre();
		optionsReponse = uneQuestion.getOptions().stream().map(optQuest -> new OptionQuestionNeutreVm(optQuest)).collect(Collectors.toList());
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<OptionQuestionNeutreVm> getOptionsReponse() {
		return optionsReponse;
	}
	public void setOptionsReponse(List<OptionQuestionNeutreVm> optionsReponse) {
		this.optionsReponse = optionsReponse;
	}

	
}
