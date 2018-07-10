package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.OptionQuestion;
import dev.repositories.question.OptionQuestionRepository;

@Service
public class OptionQuestionService {

	private OptionQuestionRepository optionQuestionRepository;

	public OptionQuestionService(OptionQuestionRepository optionQuestionRepository) {
		super();
		this.optionQuestionRepository = optionQuestionRepository;
	}

	public List<OptionQuestion> lister() {
		return optionQuestionRepository.findAll();
	}

}
