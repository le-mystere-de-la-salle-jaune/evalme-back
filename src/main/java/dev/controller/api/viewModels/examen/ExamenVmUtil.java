package dev.controller.api.viewModels.examen;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.entites.Classe;
import dev.entites.Examen;
import dev.entites.ExamenReponse;
import dev.entites.Question;
import dev.entites.Quizz;
import dev.entites.Stagiaire;
import dev.metiers.ExamenReponseService;
import dev.metiers.ExamenService;
import dev.metiers.StagiaireService;

@Service
public class ExamenVmUtil {

	private ExamenService examenService;
	private StagiaireService stagiaireService;
	private ExamenReponseService examenReponseService;

	public ExamenVmUtil(ExamenService examenService, StagiaireService stagiaireService,
			ExamenReponseService examenReponseService) {
		this.examenService = examenService;
		this.stagiaireService = stagiaireService;
		this.examenReponseService = examenReponseService;
	}

	@Transactional
	public QuestionExamVm getRandomQuestion(Long idExam, Long idStagiaire) {
		List<Question> questions = examenService.getById(idExam).getQuizz().getQuestions();
		List<ExamenReponse> quesTraite = examenReponseService.findAll().stream()
				.filter(r -> (r.getExamen().getId().equals(idExam) && r.getStagiaire().getId().equals(idStagiaire)))
				.collect(Collectors.toList());
		List<Question> questNonTraite = questions;

		for (Question q : questions) {
			for (ExamenReponse er : quesTraite) {
				if (er.getQuestion().getId().equals(q.getId())) {
					questNonTraite.remove(q);
				}
			}
		}

		QuestionExamVm questionExamVm = new QuestionExamVm();

		if (questNonTraite.size() >= 1) {
			Question q = questNonTraite.get(0);
			questionExamVm.setId(q.getId());
			questionExamVm.setTitre(q.getTitre());
			questionExamVm.setOptions(q.getOptions().stream()
					.map(oq -> new OptionQuestionVm(oq.getId(), oq.getLibelle())).collect(Collectors.toList()));

			questionExamVm.setLast(false);
		} else {
			questionExamVm.setId(null);
			questionExamVm.setLast(true);
			questionExamVm.setTitre(null);
			questionExamVm.setOptions(null);
		}
		return questionExamVm;
	}

	@Transactional
	public List<ExamenVm> listStagiaireExam(Long id) {

		List<Examen> exams = examenService.lister();
		Stagiaire stagiaire = stagiaireService.findStagiaireById(id);

		List<ExamenVm> examenVm = exams.stream()
				.filter(exam -> exam.getClasse().getId().equals(stagiaire.getClasse().getId()))
				.map(examen -> new ExamenVm(examen)).collect(Collectors.toList());

		return examenVm;
	}

	@Transactional
	public List<ExamenNoteVm> listerResultatsStagiaire(Long idStagiaire) {

		List<Examen> exams = examenService.lister();
		Stagiaire stagiaire = stagiaireService.findStagiaireById(idStagiaire);

		List<ExamenNoteVm> examenNoteVm = exams.stream()
				.filter(e -> e.getClasse().getId().equals(stagiaire.getClasse().getId()))
				.map(e -> new ExamenNoteVm(e, idStagiaire)).collect(Collectors.toList());
		return examenNoteVm;
	}

	@Transactional
	public List<ExamenVm> listAllExam() {

		List<ExamenVm> listExam = examenService.lister().stream().map(ExamenVm::new).collect(Collectors.toList());

		return listExam;
	}

	@Transactional
	public ExamenVm createExamen(Examen examen) {

		return new ExamenVm(examen);

	}

	@Transactional
	public Examen ExamenVmCreateToEntity(ExamenVmCreate examenVm) {

		Examen examen = new Examen();

		Classe classe = new Classe();
		classe.setId(examenVm.getClasseId());
		Quizz quizz = new Quizz();
		quizz.setId(examenVm.getQuizzId());

		examen.setClasse(classe);
		examen.setQuizz(quizz);
		examen.setTitre(examenVm.getTitre());

		return examen;
	}

	@Transactional
	public Examen ExamenVmCreateToEntity(ExamenVmCreate examenVm, Long id) {

		Examen examen = ExamenVmCreateToEntity(examenVm);
		examen.setId(id);

		return examen;
	}
}
