package dev.controller.api.sondage.viewModels;

import java.util.List;

public class SondageCreateVM {

	private String titre;
	private long id;
	private List<OptionSondageLibelleDescVM> options;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<OptionSondageLibelleDescVM> getOptions() {
		return options;
	}

	public void setOptions(List<OptionSondageLibelleDescVM> options) {
		this.options = options;
	}
}
