package dev.repositories.classe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.JpaTestConfig;
import dev.entites.Classe;
import dev.entites.Stagiaire;

@ContextConfiguration(classes = { ClasseRepositoryJPA.class, JpaTestConfig.class })
@RunWith(SpringRunner.class)
public class ClasseRepositoryJPATest {

	@Autowired
	ClasseRepository classeRepositoryJPA;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Classe> classes = classeRepositoryJPA.findAll();
		assertThat(classes).isNotEmpty();
	}

	@Test
	public void testSave() {
		List<Classe> classes = classeRepositoryJPA.findAll();
		int size = classes.size();
		Classe classe = new Classe("D15");
		List<Stagiaire> stagiaires = new ArrayList<>();
		classe.setStagiaires(stagiaires);
		classeRepositoryJPA.save(classe);
		classes = classeRepositoryJPA.findAll();
		assertThat(classes.size()).isEqualTo(size + 1);
	}

	@Test
	public void testUpdate() {
		List<Classe> classes = classeRepositoryJPA.findAll();
		Classe c = classes.get(0);
		String nom = c.getNom();
		c.setNom("D15");
		classeRepositoryJPA.update(c);
		classes = classeRepositoryJPA.findAll();

		assertThat(classes.get(0).getNom()).isEqualTo("D15");
		assertThat(classes.get(0).getNom()).isNotEqualTo(nom);
	}

	@Test
	public void delete() {
		List<Classe> classes = classeRepositoryJPA.findAll();
		int size = classes.size();
		Classe c = classes.get(0);
		Long id = c.getId();
		classeRepositoryJPA.delete(c);
		classes = classeRepositoryJPA.findAll();

		assertThat(classes.size()).isEqualTo(size - 1); //
		assertThat(classes.get(0).getId()).isNotEqualTo(id);
	}

	/*
	 *
	 * @Test public Optional<Classe> findById() { return null; }
	 */

}
