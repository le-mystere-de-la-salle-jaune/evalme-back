package dev.entites;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultatsondage")
public class ResultatSondage extends BaseEntite {

	@ManyToOne
	@JoinColumn(name = "id_stagiaire")
	private Stagiaire stagiaire;

	@ManyToOne
	@JoinColumn(name = "id_sondage")
	private Sondage sondage;

	@ManyToOne
	@JoinColumn(name = "id_optionSondage")
	private OptionSondage optionSondage;

	public ResultatSondage() {
		super();
	}

	public ResultatSondage(Stagiaire stagiaire, Sondage sondage, OptionSondage optionSondage) {
		super();
		this.stagiaire = stagiaire;
		this.sondage = sondage;
		this.optionSondage = optionSondage;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public OptionSondage getOptionSondage() {
		return optionSondage;
	}

	public void setOptionSondage(OptionSondage optionSondage) {
		this.optionSondage = optionSondage;
	}

}
