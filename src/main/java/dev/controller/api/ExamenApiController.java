package dev.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.api.viewModels.examen.ExamenNoteVm;
import dev.controller.api.viewModels.examen.ExamenReponseVm;
import dev.controller.api.viewModels.examen.ExamenVm;
import dev.controller.api.viewModels.examen.ExamenVmCreate;
import dev.controller.api.viewModels.examen.ExamenVmUtil;
import dev.controller.api.viewModels.examen.QuestionExamVm;
import dev.entites.Examen;
import dev.entites.ExamenReponse;
import dev.metiers.ClasseService;
import dev.metiers.ExamenReponseService;
import dev.metiers.ExamenService;
import dev.metiers.OptionQuestionService;
import dev.metiers.QuestionService;
import dev.metiers.QuizzService;
import dev.metiers.StagiaireService;

@RestController
@RequestMapping("/api/examens")
public class ExamenApiController {

	private ExamenService examenService;
	private ExamenVmUtil examenVmUtil;
	private QuizzService quizzService;
	private ClasseService classeService;
	private StagiaireService stagiaireService;
	private ExamenReponseService examReponseService;
	private QuestionService questionService;
	private OptionQuestionService optionQuestionService;

	public ExamenApiController(ExamenService examenService, QuizzService quizzService, ClasseService classeService,
			StagiaireService stagiaireService, ExamenVmUtil examenVmUtil, ExamenReponseService examReponseService,
			QuestionService questionService, OptionQuestionService optionQuestionService) {
		super();
		this.examenService = examenService;
		this.quizzService = quizzService;
		this.classeService = classeService;
		this.examenVmUtil = examenVmUtil;
		this.examReponseService = examReponseService;
		this.stagiaireService = stagiaireService;
		this.questionService = questionService;
		this.optionQuestionService = optionQuestionService;
	}

	@GetMapping("/{idExam}/{idStagiaire}")
	public ResponseEntity<QuestionExamVm> getRandomQuestionForExamen(@PathVariable Long idExam,
			@PathVariable Long idStagiaire) {
		return ResponseEntity.ok(examenVmUtil.getRandomQuestion(idExam, idStagiaire));
	}

	@PostMapping("/reponse")
	public ResponseEntity<ExamenReponseVm> saveReponse(@RequestBody ExamenReponseVm examenReponseVm,
			HttpServletResponse response) {
		ExamenReponse reponse = new ExamenReponse();
		reponse.setExamen(examenService.getById(examenReponseVm.getIdExamen()));
		reponse.setStagiaire(stagiaireService.findStagiaireById(examenReponseVm.getIdStagiaire()));
		reponse.setQuestion(questionService.findById(examenReponseVm.getIdQuestion()));
		reponse.setOptionQuestion(optionQuestionService.findById(examenReponseVm.getIdOptionQuestion()));

		examReponseService.saveResultExamenStagiaireQuestion(reponse);

		return ResponseEntity.ok(examenReponseVm);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<ExamenVm>> listerParIdStagiaire(@PathVariable Long id) {
		return ResponseEntity.ok(examenVmUtil.listStagiaireExam(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExamenVm>> lister() {

		return ResponseEntity.ok(examenVmUtil.listAllExam());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> ajouter(@RequestBody ExamenVmCreate examenVmCreate, HttpServletResponse response) {
		Examen examen = new Examen();

		if (classeService.trouverClasseParId(examenVmCreate.getClasseId()) != null) {
			if (quizzService.findQuizzById(examenVmCreate.getQuizzId()) != null) {

				examen = examenVmUtil.ExamenVmCreateToEntity(examenVmCreate);

				examenService.ajouter(examen);

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quizz ID send does not exist");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Classe ID send does not exist");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(examenVmUtil.createExamen(examen));

	}

	@RequestMapping(value = "/{examenId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> supprimer(@PathVariable Long examenId) {

		if (examenService.exist(examenId)) {
			examenService.deleteAllNote(examenId);
			examenService.deleteById(examenId);
			return ResponseEntity.status(HttpStatus.OK).body("Examen deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Examen id don't match any exams");
		}

	}

	@RequestMapping(value = "/{examenId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateExamen(@PathVariable Long examenId, @RequestBody ExamenVmCreate examenVmCreate) {

		if (examenService.exist(examenId)) {

			Examen examen = new Examen();
			examen.setId(examenId);

			if (classeService.trouverClasseParId(examenVmCreate.getClasseId()) != null) {
				if (quizzService.findQuizzById(examenVmCreate.getQuizzId()) != null) {
					examenService.updateById(examenVmUtil.ExamenVmCreateToEntity(examenVmCreate, examenId));

				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quizz ID send does not exist");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Classe ID send does not exist");
			}

			return ResponseEntity.status(HttpStatus.OK).body("Examen updated successfully");

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Examen id don't match any exams");
		}

	}

	@GetMapping("/notes/{idStagiaire}")
	public ResponseEntity<List<ExamenNoteVm>> resultatExamenStagiaire(@PathVariable Long idStagiaire) {
		return ResponseEntity.ok(examenVmUtil.listerResultatsStagiaire(idStagiaire));
	}

}
