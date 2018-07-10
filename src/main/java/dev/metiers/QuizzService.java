package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Quizz;
import dev.repositories.quizz.QuizzRepository;

@Service
public class QuizzService {

	private QuizzRepository quizzRepository;

	public QuizzService(QuizzRepository quizzRepository) {
		super();
		this.quizzRepository = quizzRepository;
	}

	public List<Quizz> lister() {
		return quizzRepository.findAll();
	}

}