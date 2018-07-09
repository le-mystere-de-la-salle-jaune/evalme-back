package dev.entites;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.services.UtilisateurServiceMemoire;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { UtilisateurServiceMemoire.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class UtilisateursServiceMemoireTest {

	@Autowired
	private UtilisateurServiceMemoire utilisateurService;

	@Test
	public void test_ENTITE_1() {

		Utilisateur utilTest = utilisateurService.findAll().get(1);

		assertTrue(utilTest.getIdentifiant().equals("11111"));
		assertTrue(utilTest.getMotDePasse().equals("11111"));
		assertTrue(utilTest.getProfil().equals(ProfilUtilisateur.STAGIAIRE));

	}

}
