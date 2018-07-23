package dev.repositories.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.entites.Question;

@Repository
public class QuestionRepositoryDataJpa implements QuestionRepository {

	@Autowired
	private QuestionDataJpaRepo questionDataJpaRepo;

	public QuestionRepositoryDataJpa(QuestionDataJpaRepo questionDataJpaRepo) {
		this.questionDataJpaRepo = questionDataJpaRepo;
	}

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return questionDataJpaRepo.findAll();
	}

	@Override
	public void save(Question question) {
		// TODO Auto-generated method stub
		questionDataJpaRepo.save(question);
	}

	@Override
	public void update(Question questionAvecId) {
		// TODO Auto-generated method stub
		questionDataJpaRepo.save(questionAvecId);

	}

	@Override
	public void delete(Question question) {
		// TODO Auto-generated method stub
		questionDataJpaRepo.delete(question);

	}

	@Override
	public Optional<Question> findById(Long id) {
		// TODO Auto-generated method stub
		return questionDataJpaRepo.findById(id);
	}

}
