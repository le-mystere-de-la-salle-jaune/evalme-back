package dev.repositories.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.entites.OptionQuestion;

@Component
public class OptionQuestionRepositoryDataJpa implements OptionQuestionRepository {

	@Autowired
	private OptionQuestionDataJpaRepo optionQuestionDataJpaRepo;

	public OptionQuestionRepositoryDataJpa(OptionQuestionDataJpaRepo optionQuestionDataJpaRepo) {
		this.optionQuestionDataJpaRepo = optionQuestionDataJpaRepo;
	}

	// NE PAS IMPLEMENTER A CE STADE, ECRIVONS LE TEST AVANT

	@Override
	public List<OptionQuestion> findAll() {
		// TODO Auto-generated method stub
		return optionQuestionDataJpaRepo.findAll();
	}

	@Override
	public void save(OptionQuestion entite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OptionQuestion entiteAvecId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(OptionQuestion entite) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<OptionQuestion> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
