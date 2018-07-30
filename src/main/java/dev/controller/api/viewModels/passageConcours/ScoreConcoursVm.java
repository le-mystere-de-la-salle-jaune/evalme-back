package dev.controller.api.viewModels.passageConcours;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreConcoursVm {

	private Integer score;
	
	@JsonProperty("passage_id")
	private Long idPassage;

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getIdPassage() {
		return idPassage;
	}

	public void setIdPassage(Long idPassage) {
		this.idPassage = idPassage;
	}
	
	
}
