package dev.controller.api.viewModels.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.controller.api.stagiaire.StagiaireVm;
import dev.entites.Classe;
import dev.entites.Stagiaire;

public class ClasseVmAjouter extends BaseVm {

	private String nom;
	@JsonIgnore
	private List<StagiaireVm> stagiairesVm = new ArrayList<>();

	public ClasseVmAjouter() {
		super();
	}

	public ClasseVmAjouter(Long id) {
		super(id);
	}

	public ClasseVmAjouter(String nom) {
		this.nom = nom;
	}

	public ClasseVmAjouter(String nom, List<StagiaireVm> stagiairesVm) {
		super();
		this.nom = nom;
		this.stagiairesVm = stagiairesVm;
	}

	public ClasseVmAjouter(Optional<Classe> classe) {

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

	public String getNomVmAjouter() {
		return nom;
	}

	public void setNomVmAjouter(String nom) {
		this.nom = nom;
	}

	public List<StagiaireVm> getStagiairesVmAjouter() {
		return stagiairesVm;
	}

	public void setStagiairesVmAjouter(List<StagiaireVm> stagiairesVm) {
		this.stagiairesVm = stagiairesVm;
	}

}
