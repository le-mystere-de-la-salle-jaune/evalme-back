package dev.controller.api.concours;

import java.util.ArrayList;
import java.util.List;

import dev.controller.api.viewModels.examen.BaseVm;
import dev.controller.api.viewModels.examen.QuizzVm;
import dev.entites.Concours;
import dev.entites.Quizz;
import dev.entites.Stagiaire;

public class ConcoursVm extends BaseVm {

	private String titre;
	private List<Stagiaire> participants;
	private List<QuizzVm> quizzes;

	public ConcoursVm(Concours c) {
		super(c.getId());
		this.titre = c.getTitre();
		this.participants = c.getParticipants();
		this.quizzes = transform(c.getQuizzes());
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

	public List<QuizzVm> getQuizzes() {
		return quizzes;
	}

	public List<QuizzVm> transform(List<Quizz> quizzes) {
		List<QuizzVm> QVM = new ArrayList<>();

		for (Quizz s : quizzes) {
			QVM.add(new QuizzVm(s.getId(), s.getTitre(), s.getQuestions().size()));
		}
		;
		return QVM;
	}

	public void setQuizzes(List<QuizzVm> quizzes) {
		this.quizzes = quizzes;
	}

}
