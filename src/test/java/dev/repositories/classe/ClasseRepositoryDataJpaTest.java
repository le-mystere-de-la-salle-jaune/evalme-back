package dev.repositories.classe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.DataJpaTestConfig;
import dev.entites.Classe;
import dev.entites.Stagiaire;

@ContextConfiguration(classes = { ClasseRepositoryDataJpa.class, DataJpaTestConfig.class })
@RunWith(SpringRunner.class)
public class ClasseRepositoryDataJpaTest {

	@Autowired
	private ClasseRepository classeRepositoryDataJpa;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Classe> classes = classeRepositoryDataJpa.findAll();
		assertThat(classes).isNotEmpty();
	}

	@Test
	public void testSave() {
		List<Classe> classes = classeRepositoryDataJpa.findAll();
		int size = classes.size();
		Classe classe = new Classe("D15");
		List<Stagiaire> stagiaires = new ArrayList<>();
		Stagiaire st1 = new Stagiaire("clopin", "brigitte", "bribri@hotmail.fr",
				"https://www.valeursactuelles.com/sites/default/files/styles/image_article/public/2018-01/brigitte%20macron%20sipa.jpg?itok=0g8jrpff");
		stagiaires.add(st1);
		classe.setStagiaires(stagiaires);
		classeRepositoryDataJpa.save(classe);
		classes = classeRepositoryDataJpa.findAll();
		assertThat(classes.size()).isEqualTo(size + 1);
	}

	@Test
	public void testUpdate() {
		List<Classe> classes = classeRepositoryDataJpa.findAll();
		Classe c = classes.get(0);
		String nom = c.getNom();
		c.setNom("D15");
		classeRepositoryDataJpa.save(c);
		classes = classeRepositoryDataJpa.findAll();

		assertThat(classes.get(0).getNom()).isEqualTo("D15");
		assertThat(classes.get(0).getNom()).isNotEqualTo(nom);
	}

	@Test
	public void delete() {
		List<Classe> classes = classeRepositoryDataJpa.findAll();
		int size = classes.size();
		Classe c = classes.get(0);
		Long id = c.getId();
		classeRepositoryDataJpa.delete(c);
		classes = classeRepositoryDataJpa.findAll();

		assertThat(classes.size()).isEqualTo(size - 1); //
		assertThat(classes.get(0).getId()).isNotEqualTo(id);
	}

	@Test
	public void findById() {
		Long id = 1L;
		Optional<Classe> classe = classeRepositoryDataJpa.findById(id);

		if (classe.isPresent()) {
			Classe classe2 = classe.get();

			assertThat(classe2).isNotNull();
			assertThat(classe2.getId()).isEqualTo(id);

		} else {
			fail();
		}
	}
}
