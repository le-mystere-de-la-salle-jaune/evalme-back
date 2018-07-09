package dev.entites;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.services.ExamenServiceMemoire;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ExamenServiceMemoire.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class ExamenServiceMemoireTest {

	@Autowired
	private ExamenServiceMemoire examenService;

	@Test
	public void test_ENTITE_1() {

		Examen examentest = examenService.findAll().get(0);

		assertTrue(examentest.getTitre().equals("Java EE"));
		assertTrue(examentest.getNotes().get(0).getNoteSur20() == 12);
		assertTrue(examentest.getClasse().getStagiaires().get(1).getEmail().equals("rourou@gmail.com"));

	}

}
