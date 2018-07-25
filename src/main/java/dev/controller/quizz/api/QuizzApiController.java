package dev.controller.quizz.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.quizz.api.viewModels.QuizzVm;
import dev.entites.Quizz;

@RestController
@RequestMapping("/api/quizzes")
public class QuizzApiController {

	private QuizzVmUtils quizzUtils;

	public QuizzApiController(QuizzVmUtils quizzUtils) {
		super();
		this.quizzUtils = quizzUtils;
	}

	@GetMapping
	public ResponseEntity<List<QuizzVm>> getList() {
		return ResponseEntity.ok(this.quizzUtils.listAllQuizzes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<QuizzVm> getQuizzById(@PathVariable Long id) {
		return ResponseEntity.ok(this.quizzUtils.getQuizzVmById(id));
	}

	@PostMapping
	public ResponseEntity<String> creer(@RequestBody QuizzVm quizzVm) {
		Quizz quizz = new Quizz();
		quizz.setTitre(quizzVm.getTitre());
		quizz.setQuestions(QuizzVmUtils.getQuestions(quizzVm.getQuestions()));
		quizzUtils.createQuizz(quizz);
		return ResponseEntity.ok("Id du quizz Créé: " + quizz.getId());
	}

}