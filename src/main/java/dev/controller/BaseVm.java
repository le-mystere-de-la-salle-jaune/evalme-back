package dev.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseVm {

	@JsonProperty("id")
	private Long id;

	public BaseVm() {

	}

	public BaseVm(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
