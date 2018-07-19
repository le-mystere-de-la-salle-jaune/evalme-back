package dev.controller.api.questions;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.api.questions.viewModels.ListerQuestionVM;
import dev.controller.api.questions.viewModels.QuestionByIdVM;

@RestController
@RequestMapping("api/questions")
public class ListerQuestionApiController {

	QuestionBuilder questionBuilder;

	public ListerQuestionApiController(QuestionBuilder questionBuilder) {
		super();
		this.questionBuilder = questionBuilder;
	}

	@GetMapping("/lister")
	public ResponseEntity<List<ListerQuestionVM>> getList() {
		return ResponseEntity.ok(questionBuilder.creerJsonLister());
	}

	@GetMapping("/lister/{id}")
	public ResponseEntity<QuestionByIdVM> getQuestion(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(questionBuilder.creerJsonListerById(id));
	}

}
