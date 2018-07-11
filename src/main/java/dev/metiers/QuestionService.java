package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Question;
import dev.repositories.question.QuestionRepository;

@Service
public class QuestionService {

	private QuestionRepository questionRepository;

	public QuestionService(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	public List<Question> lister() {
		return questionRepository.findAll();
	}

	/**
	 * @return the questionRepository
	 */
	public QuestionRepository getQuestionRepository() {
		return questionRepository;
	}

	/**
	 * @param questionRepository
	 *            the questionRepository to set
	 */
	public void setQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

}
