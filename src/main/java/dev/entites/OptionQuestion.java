package dev.entites;

import javax.validation.constraints.NotEmpty;

public class OptionQuestion extends BaseEntite {

	@NotEmpty
	private String libelle;
	@NotEmpty
	private Boolean ok;

	public OptionQuestion() {
		super();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the ok
	 */
	public Boolean getOk() {
		return ok;
	}

	/**
	 * @param ok
	 *            the ok to set
	 */
	public void setOk(Boolean ok) {
		this.ok = ok;
	}

}
