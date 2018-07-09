package dev.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.entites.Classe;
import dev.services.classe.ClasseServiceMemoire;

@ContextConfiguration(classes = { ClasseServiceMemoire.class })
@RunWith(SpringRunner.class)
public class ClasseServiceMemoireTest {

	@Autowired
	public ClasseServiceMemoire classeServiceMemoire = new ClasseServiceMemoire();

	@Test
	public void TestfindAll() {
		// TODO Auto-generated method stub
		List<Classe> classe = classeServiceMemoire.findAll();

		assertThat(classe).isNotEmpty();
		assertThat(classe.size()).isEqualTo(3);
		assertThat(classe.get(0).getStagiaires().get(0).getPrenom()).isEqualTo("Maxime");
	}

	@Test
	public void TestSave() {
		// TODO Auto-generated method stub
		List<Classe> classe = classeServiceMemoire.findAll();
		Classe c = classe.get(0);
		c.setId(4L);

		classe.add(c);

		assertThat(classe.size()).isEqualTo(4);
	}

	@Test
	public void TestUpdate() {
		// TODO Auto-generated method stub
		List<Classe> classe = classeServiceMemoire.findAll();
		Classe c = classe.get(0);

		c.setNom("D21");

		classeServiceMemoire.update(c);

		assertThat(classe.get(0).getNom()).isEqualTo("D21");
	}

	@Test
	public void TestDelete() {
		// TODO Auto-generated method stub
		List<Classe> classe = classeServiceMemoire.findAll();
		Classe c = classe.get(3);

		classe.remove(c);

		assertThat(classe.size()).isEqualTo(3);

	}

}
