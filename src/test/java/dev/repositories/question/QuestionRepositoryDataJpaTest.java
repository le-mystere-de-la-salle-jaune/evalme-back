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

		OptionQuestion option = new OptionQuestion();
		option.setLibelle("42");
		option.setOk(true);

		question.getOptions().add(option);

		questionRepositoryDataJpa.save(question);

		List<Question> maListe = questionRepositoryDataJpa.findAll();

		assertTrue(maListe.get(maListe.size() - 1).getTitre().equals(question.getTitre()));
		assertTrue(maListe.get(maListe.size() - 1).getOptions().get(0).getLibelle().equals(option.getLibelle()));

	}

	@Test
	public void test_Update() {
		Question question = new Question();
		question.setTitre("Est-ce que c'est drôle ?");

		OptionQuestion option = new OptionQuestion();
		option.setLibelle("42");
		option.setOk(true);

		question.getOptions().add(option);

		questionRepositoryDataJpa.save(question);

		long id = questionRepositoryDataJpa.findAll().get(questionRepositoryDataJpa.findAll().size() - 1).getId();

		Question autreQuestion = new Question();
		autreQuestion.setTitre("C'est pas drôle ?");
		autreQuestion.getOptions().add(option);
		autreQuestion.setId(id);

		questionRepositoryDataJpa.update(autreQuestion);

		List<Question> maListe = questionRepositoryDataJpa.findAll();

		assertTrue(maListe.get(maListe.size() - 1).getTitre().equals(autreQuestion.getTitre()));
		assertTrue(maListe.get(maListe.size() - 1).getOptions().get(0).getLibelle().equals(option.getLibelle()));

	}

	@Test
	public void test_Delete() {
		Question question = new Question();
		question.setTitre("Est-ce que c'est drôle ?");

		OptionQuestion option = new OptionQuestion();
		option.setLibelle("42");
		option.setOk(true);

		question.getOptions().add(option);

		questionRepositoryDataJpa.save(question);

		List<Question> maListeAvec = questionRepositoryDataJpa.findAll();

		questionRepositoryDataJpa.delete(question);

		List<Question> maListeSans = questionRepositoryDataJpa.findAll();

		assertTrue(!maListeAvec.containsAll(maListeSans));

	}

	@Test
	public void test_FindById() {

		Question question = new Question();
		question.setTitre("Est-ce que c'est drôle ?");

		OptionQuestion option = new OptionQuestion();
		option.setLibelle("42");
		option.setOk(true);

		question.getOptions().add(option);

		questionRepositoryDataJpa.save(question);

		List<Question> maListe = questionRepositoryDataJpa.findAll();

		long id = maListe.get(maListe.size() - 1).getId();

		Question questionBis = questionRepositoryDataJpa.findById(id).get();

		assertTrue(question.getTitre().equals(questionBis.getTitre()));
		assertTrue(question.getOptions().get(0).getLibelle().equals(questionBis.getOptions().get(0).getLibelle()));

	}

}
