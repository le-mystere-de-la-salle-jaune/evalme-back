package dev.controller.api.viewModels.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.controller.api.stagiaire.StagiaireVm;
import dev.entites.Classe;
import dev.entites.Stagiaire;

public class ClasseVmDetail extends BaseVm {

	private String nom;
	private List<StagiaireVm> stagiairesVm = new ArrayList<>();

	public ClasseVmDetail() {
		super();
	}

	public ClasseVmDetail(String nom, List<StagiaireVm> stagiairesVm) {
		super();
		this.nom = nom;
		this.stagiairesVm = stagiairesVm;
	}

	public ClasseVmDetail(Optional<Classe> classe) {

		if (classe.isPresent()) {
			Classe c = classe.get();
			this.setId(c.getId());
			this.nom = c.getNom();
			List<StagiaireVm> stagiairesVm = new ArrayList<>();
			for (Stagiaire st : c.getStagiaires()) {
				StagiaireVm stVm = new StagiaireVm(st);
				stagiairesVm.add(stVm);
			}
			this.stagiairesVm = stagiairesVm;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<StagiaireVm> getStagiairesVm() {
		return stagiairesVm;
	}

	public void setStagiairesVm(List<StagiaireVm> stagiairesVm) {
		this.stagiairesVm = stagiairesVm;
	}

}
