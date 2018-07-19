package dev.controller.quizz.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.quizz.api.viewModels.QuizzVm;

@RestController
@RequestMapping("/api/quizzes")
public class QuizzApiController {

	private QuizzVmUtils quizzUtils;

	public QuizzApiController(QuizzVmUtils quizzUtils) {
		super();
		this.quizzUtils = quizzUtils;

	}

	@GetMapping("/lister")
	public ResponseEntity<List<QuizzVm>> getList() {
		return ResponseEntity.ok(this.quizzUtils.listAllQuizzes());
	}

	@GetMapping("/lister/{id}")
	public ResponseEntity<QuizzVm> getQuizzById(@PathVariable Long id) {
		return ResponseEntity.ok(this.quizzUtils.getQuizzVmById(id));
	}

}