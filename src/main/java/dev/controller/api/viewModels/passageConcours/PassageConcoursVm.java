package dev.controller.api.viewModels.passageConcours;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.controller.api.viewModels.BaseVm;

public class PassageConcoursVm extends BaseVm {

	public PassageConcoursVm(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("concours_id")
	private Long concours;

	@JsonProperty("stagiaire_id")
	private Long stagiaire;

	public Long getConcours() {
		return concours;
	}

	public void setConcours(Long concours) {
		this.concours = concours;
	}

	public Long getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Long stagiaire) {
		this.stagiaire = stagiaire;
	}

}
