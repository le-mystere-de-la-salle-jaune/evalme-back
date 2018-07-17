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
import dev.entites.Question;

@ContextConfiguration(classes = { QuestionRepositoryDataJpa.class, DataJpaTestConfig.class })
@RunWith(SpringRunner.class)
public class QuestionRepositoryDataJpaTest {

	@Autowired
	private QuestionRepository questionRepositoryDataJpa;

	// TODO créer les cas de test

	@Test
	public void test_FindAll() {
		assertTrue(!questionRepositoryDataJpa.findAll().isEmpty());
	}

	@Test
	public void test_Save() {

		Question question = new Question();
		question.setTitre("Est-ce que c'est drôle ?");
		question.setId((long) 15);

		questionRepositoryDataJpa.save(question);

		OptionQuestion option = new OptionQuestion();
		option.setId((long) 42);
		option.setLibelle("42");
		option.setOk(true);

		question.getOptions().add(option);

		List<Question> maListe = questionRepositoryDataJpa.findAll();

		// assertTrue(maListe.get(maListe.size() - 1).getTitre().equals("Est-ce
		// que c'est drôle ?"));

	}

	@Test
	public void test_Update() {

	}

	@Test
	public void test_Delete() {
		/*
		 * Question quizz = new Question(); quizz.setId((long) 123456789);
		 * quizz.setTitre("Trop bien !");
		 *
		 * OptionQuestion option = new OptionQuestion(); option.setId((long)
		 * 12); option.setLibelle("LOL"); option.setOk(false);
		 *
		 * List<OptionQuestion> list = new ArrayList<OptionQuestion>();
		 * list.add(option);
		 *
		 * quizz.setOptions(list);
		 *
		 * questionRepositoryJpa.save(quizz);
		 *
		 * questionRepositoryJpa.delete(quizz); //
		 * assertTrue(!questionRepositoryJdbc.getQuestions().contains(quizz));
		 *
		 */
	}

	@Test
	public void test_FindById() {

	}

}
