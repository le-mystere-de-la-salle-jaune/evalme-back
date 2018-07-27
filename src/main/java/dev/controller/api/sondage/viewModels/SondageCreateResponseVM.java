package dev.controller.api.sondage.viewModels;

public class SondageCreateResponseVM {

	private String titre;
	private ClasseListerSondageVM classe;
	private long nb_options;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ClasseListerSondageVM getClasse() {
		return classe;
	}

	public void setClasse(ClasseListerSondageVM classe) {
		this.classe = classe;
	}

	public long getNb_options() {
		return nb_options;
	}

	public void setNb_options(long nb_options) {
		this.nb_options = nb_options;
	}

}
/*
 * "titre" : "Comment avez-vous trouver le cours Java", "classe_id" : 1,
 * "options" : [ { "libelle" : "Top", "description" : "..." }, { "libelle" :
 * "Moyen", "description" : "..." } ]
 */