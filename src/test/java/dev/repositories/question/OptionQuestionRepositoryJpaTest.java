package dev.repositories.question;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.JpaTestConfig;
import dev.entites.OptionQuestion;

@ContextConfiguration(classes = { OptionQuestionRepositoryJpa.class, JpaTestConfig.class })
@RunWith(SpringRunner.class)
public class OptionQuestionRepositoryJpaTest {

	@Autowired
	private OptionQuestionRepository optionQuestionRepository;

	// TODO créer les cas de test

	@Test
	@Ignore
	public void test_FindAll() {
		assertTrue(!optionQuestionRepository.findAll().isEmpty());
	}

	@Ignore
	@Test
	public void test_Save() {
		OptionQuestion option = new OptionQuestion();
		option.setLibelle("LOL");
		option.setOk(false);
		optionQuestionRepository.save(option);
		List<OptionQuestion> maListe = optionQuestionRepository.findAll();

		assertTrue(maListe.get(maListe.size()-1).getLibelle().equals("LOL"));
		assertTrue(!maListe.get(maListe.size()-1).getOk());
	}

	@Test
	public void test_Update() {
		/*
		 * OptionQuestion option = new OptionQuestion();
		 * option.setLibelle("LOL"); option.setOk(false);
		 * optionQuestionRepository.save(option);
		 * 
		 * OptionQuestion newOption = new OptionQuestion();
		 * newOption.setId(option.getId()); newOption.setLibelle("Pas LOL");
		 * newOption.setOk(true); optionQuestionRepository.update(newOption);
		 * 
		 * assertTrue(optionQuestionRepository.findAll().get(3).getLibelle().
		 * equals("Pas LOL"));
		 * assertTrue(optionQuestionRepository.findAll().get(3).getOk());
		 */

	}

	@Test
	public void test_Delete() {
		/*
		 * OptionQuestion option = new OptionQuestion();
		 * option.setLibelle("LOL"); option.setOk(false);
		 * optionQuestionRepository.save(option);
		 * optionQuestionRepository.delete(option);
		 * assertTrue(!optionQuestionRepository.findAll().contains(option));
		 */
	}

}
