package dev.controller.examen.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.examen.api.viewModels.ExamenVm;
import dev.controller.examen.api.viewModels.ExamenVmCreate;
import dev.controller.examen.api.viewModels.ExamenVmUtil;
import dev.entites.Examen;
import dev.metiers.ClasseService;
import dev.metiers.ExamenService;
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

	public ExamenApiController(ExamenService examenService, QuizzService quizzService, ClasseService classeService,
			StagiaireService stagiaireService, ExamenVmUtil examenVmUtil) {
		super();
		this.examenService = examenService;
		this.quizzService = quizzService;
		this.classeService = classeService;
		this.stagiaireService = stagiaireService;
		this.examenVmUtil = examenVmUtil;

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExamenVm>> lister() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		return ResponseEntity.ok(examenVmUtil.listAllExam());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> ajouter(@RequestBody ExamenVmCreate examenVmCreate, HttpServletResponse response) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		Examen examen = new Examen();

		if (classeService.trouverClasseParId(examenVmCreate.getClasseId()) != null) {
			if (quizzService.findQuizzById(examenVmCreate.getQuizzId()).isPresent()) {
				examen.setClasse(classeService.trouverClasseParId(examenVmCreate.getClasseId()));
				examen.setQuizz(quizzService.findQuizzById(examenVmCreate.getQuizzId()).orElse(null));
				examen.setTitre(examenVmCreate.getTitre());

				examenService.ajouter(examen);

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quizz ID send does not exist");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Classe ID send does not exist");
		}

		return ResponseEntity.status(HttpStatus.OK).body(examenVmUtil.createExamen(examen));

	}

	@RequestMapping(value = "/{examenId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> supprimer(@PathVariable Long examenId) {

		if (examenService.exist(examenId)) {
			examenService.deleteById(examenId);
			return ResponseEntity.status(HttpStatus.OK).body("Examen deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Examen id don't match any exams");
		}

	}

}
