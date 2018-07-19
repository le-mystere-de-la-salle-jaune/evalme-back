package dev.controller.api.concours;

import java.util.List;

import dev.controller.api.viewModels.examen.BaseVm;
import dev.entites.Concours;
import dev.entites.Quizz;
import dev.entites.Stagiaire;

public class ConcoursVm extends BaseVm {

	private String titre;
	private List<Stagiaire> participants;
	private List<Quizz> quizzes;

	public ConcoursVm(String titre, List<Stagiaire> participants, List<Quizz> quizzes) {
		super();
		this.titre = titre;
		this.participants = participants;
		this.quizzes = quizzes;
	}

	public ConcoursVm(Concours c) {
		super();
		this.titre = c.getTitre();
		this.participants = c.getParticipants();
		this.quizzes = c.getQuizzes();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getParticipants() {
		String ss;
		ss = "[ ";
		for (Stagiaire s : participants) {
			ss += s.getId() + " ";
		}
		;
		ss += "]";
		return ss;
	}

	public void setParticipants(List<Stagiaire> participants) {
		this.participants = participants;
	}

	public String getQuizzes() {
		String Qz;
		Qz = "[ ";
		for (Quizz s : quizzes) {
			Qz += s.getId() + " ";
		}
		;
		Qz += "]";
		return Qz;
	}

	public void setQuizzes(List<Quizz> quizzes) {
		this.quizzes = quizzes;
	}

}
