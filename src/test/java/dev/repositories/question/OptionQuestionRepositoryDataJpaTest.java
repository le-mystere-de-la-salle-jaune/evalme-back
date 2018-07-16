package dev.repositories.question;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.DataJpaTestConfig;
import dev.entites.OptionQuestion;

@ContextConfiguration(classes = { OptionQuestionRepositoryDataJpa.class, DataJpaTestConfig.class })
@RunWith(SpringRunner.class)
public class OptionQuestionRepositoryDataJpaTest {

	@Autowired
	private OptionQuestionRepository optionQuestionRepositoryDataJpa;

	// TODO créer les cas de test

	@Test
	public void test_FindAll() {
		assertTrue(!optionQuestionRepositoryDataJpa.findAll().isEmpty());
	}

	@Test
	public void test_FindById() {

	}

	@Test
	public void test_Save() {
		OptionQuestion option = new OptionQuestion();
		option.setLibelle("LOL");
		option.setOk(false);
		optionQuestionRepositoryDataJpa.save(option);
		List<OptionQuestion> maListe = optionQuestionRepositoryDataJpa.findAll();

		// assertTrue(maListe.get(3).getLibelle().equals("LOL"));
		// Convertir le donnée byte en booléen ?
		// assertTrue(maListe.get(3).getOk());
	}

	@Test
	public void test_Update() {
		OptionQuestion option = new OptionQuestion();
		option.setId((long) 12);
		option.setLibelle("LOL");
		option.setOk(false);
		optionQuestionRepositoryDataJpa.save(option);

		OptionQuestion newOption = new OptionQuestion();
		newOption.setId((long) 12);
		newOption.setLibelle("Pas LOL");
		newOption.setOk(true);
		optionQuestionRepositoryDataJpa.update(newOption);

		// int id =
		// optionQuestionRepositoryJdbc.getOptionQuestions().indexOf(newOption);

		// assertTrue(optionQuestionRepositoryJdbc.getOptionQuestions().get(id).getLibelle().equals("Pas
		// LOL")
		// &&
		// optionQuestionRepositoryJdbc.getOptionQuestions().get(id).getOk());

	}

	@Test
	public void test_Delete() {
		OptionQuestion option = new OptionQuestion();
		option.setId((long) 12);
		option.setLibelle("LOL");
		option.setOk(false);
		optionQuestionRepositoryDataJpa.save(option);
		optionQuestionRepositoryDataJpa.delete(option);
		// assertTrue(!optionQuestionRepositoryJdbc.getOptionQuestions().contains(option));
	}

}
