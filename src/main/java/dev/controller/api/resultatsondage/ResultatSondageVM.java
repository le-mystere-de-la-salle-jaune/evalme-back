package dev.controller.api.resultatsondage;

import dev.entites.OptionSondage;
import dev.entites.ResultatSondage;
import dev.entites.Sondage;
import dev.entites.Stagiaire;
import dev.metiers.OptionSondageService;
import dev.metiers.SondageService;
import dev.metiers.StagiaireService;

public class ResultatSondageVM extends BaseEntiteVm {

	private Stagiaire stagiaire;

	private Sondage sondage;

	private OptionSondage optionSondage;

	private StagiaireService sgservice;

	private OptionSondageService osservice;

	private SondageService sdservice;

	public ResultatSondageVM() {
		super();
	}

	public ResultatSondageVM(Stagiaire stagiaire, Sondage sondage, OptionSondage optionSondage) {
		super();
		this.stagiaire = stagiaire;
		this.sondage = sondage;
		this.optionSondage = optionSondage;
	}

	public ResultatSondageVM(ResultatSondage rs) {
		super(rs.getId());

		this.stagiaire = rs.getStagiaire();
		this.sondage = rs.getSondage();
		this.optionSondage = rs.getOptionSondage();
	}

	public Long getStagiaire() {
		return stagiaire.getId();
	}

	public Long getStagiaireClasse() {
		return stagiaire.getClasse().getId();
	}

	public void setStagiaire(long idstagiaire) {
		this.stagiaire = sgservice.findStagiaireById(idstagiaire);
	}

	public Long getSondage() {
		return sondage.getId();
	}

	public String getSondageName() {
		return sondage.getTitre();
	}

	public void setSondage(long idsondage) {
		try {
			this.sondage = sdservice.findById(idsondage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Long getOptionSondage() {
		return optionSondage.getId();
	}

	public String getOptionSondageLibelle() {
		return optionSondage.getLibelle();
	}

	public void setOptionSondage(long idoptionSondage) throws Exception {
		this.optionSondage = osservice.findById(idoptionSondage);
	}

}
