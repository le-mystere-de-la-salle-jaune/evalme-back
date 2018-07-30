package dev.controller.api.viewModels.examen;

import java.util.List;

public class QuestionExamVm {

	private Long id;
	private String titre;
	private List<OptionQuestionVm> options;
	private boolean last;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
