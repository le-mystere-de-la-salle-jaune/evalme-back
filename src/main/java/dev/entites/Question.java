package dev.entites;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Question extends BaseEntite {

	@NotEmpty
	private String titre;

	@NotEmpty
	private List<OptionQuestion> options;

	public Question() {
		super();
	}

	public Question(String id, String titre) {
		super();
		this.setId(Long.parseLong(id));
		this.titre = titre;
		this.options = new ArrayList<OptionQuestion>();
	}

	public Question(String titre) {
		super();
		this.titre = titre;
	}

	public Question(String titre, List<OptionQuestion> options) {
		super();
		this.titre = titre;
		this.options = options;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<OptionQuestion> getOptions() {
		return options;
	}

	public void setOptions(List<OptionQuestion> options) {
		this.options = options;
	}
}
