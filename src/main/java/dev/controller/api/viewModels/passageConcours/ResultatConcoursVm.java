package dev.controller.api.viewModels.passageConcours;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.controller.api.viewModels.BaseVm;

public class ResultatConcoursVm extends BaseVm {

	@JsonProperty("concours_id")
	private Long idConcours;
	@JsonProperty("concours_titre")
	private String titreConcours;

	private int rang;
	
	public ResultatConcoursVm(Long id, Long idConcours, String titre, int rang){
		super(id);
		this.idConcours = idConcours;
		this.titreConcours = titre;
		this.rang = rang;
	}

	public Long getIdConcours() {
		return idConcours;
	}

	public void setIdConcours(Long idConcours) {
		this.idConcours = idConcours;
	}

	public String getTitreConcours() {
		return titreConcours;
	}

	public void setTitreConcours(String titreConcours) {
		this.titreConcours = titreConcours;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}
	
	
	
}
