package dev.controller.api.viewModels.examen;

import java.util.List;

import dev.controller.api.viewModels.classe.BaseVm;

public class QuestionExamVm extends BaseVm {

	private String titre;
	private List<OptionQuestionVm> options;
	private boolean last;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<OptionQuestionVm> getOptions() {
		return options;
	}

	public void setOptions(List<OptionQuestionVm> options) {
		this.options = options;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

}
