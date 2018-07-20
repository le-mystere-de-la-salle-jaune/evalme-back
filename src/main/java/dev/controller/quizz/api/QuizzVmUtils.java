package dev.controller.quizz.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.quizz.api.viewModels.QuestionVm;
import dev.controller.quizz.api.viewModels.QuizzVm;
import dev.entites.Question;
import dev.entites.Quizz;
import dev.metiers.QuizzService;

@Service
public class QuizzVmUtils {

	private QuizzService quizzService;

	public QuizzVmUtils(QuizzService quizzService) {
		this.quizzService = quizzService;
	}

	@Transactional
	public List<QuizzVm> listAllQuizzes() {
		List<QuizzVm> listExam = quizzService.lister().stream().map(QuizzVm::new).collect(Collectors.toList());
		return listExam;
	}

	@Transactional
	public QuizzVm getQuizzVmById(Long id) {
		return new QuizzVm(quizzService.findQuizzById(id).get());
	}

	@Transactional
	public void createQuizz(Quizz quizz) {
		this.quizzService.save(quizz);
	}

	public static List<QuestionVm> getQuestionsVm(List<Question> questions) {
		List<QuestionVm> questionsVm = new ArrayList<>();
		for (Question question : questions) {
			questionsVm.add(new QuestionVm(question));
		}
		return questionsVm;
	}

	public static List<Question> getQuestions(List<QuestionVm> questionsVm) {
		List<Question> questions = new ArrayList<>();
		for (QuestionVm questionVm : questionsVm) {
			questions.add(new Question(questionVm.getTitre()));
		}
		return questions;
	}
}
