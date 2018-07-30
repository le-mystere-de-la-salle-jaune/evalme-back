package dev.controller.api.questions.viewModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.controller.api.viewModels.BaseVm;
import dev.entites.OptionQuestion;

public class OptionQuestionNeutreVm extends BaseVm{

	@JsonProperty("libelle")
	private String libelle;
	
	public OptionQuestionNeutreVm(OptionQuestion optQuest) {
		super(optQuest.getId());
		libelle = optQuest.getLibelle();
		
	}
}
