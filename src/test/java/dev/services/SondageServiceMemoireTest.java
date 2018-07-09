package dev.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.entites.Sondage;
import dev.services.sondage.SondageServiceMemoire;

@ContextConfiguration(classes = { SondageServiceMemoire.class })
@RunWith(SpringRunner.class)
public class SondageServiceMemoireTest {

	@Autowired
	private SondageServiceMemoire service;

	@Test
	public void testFindAll() {
		List<Sondage> s = service.findAll();
		assertThat(s.size()).isEqualTo(3);
	}

	@Test
	public void testSave() {
		assertThat(service.findAll().size()).isEqualTo(3);
		service.save(new Sondage());
		assertThat(service.findAll().size()).isEqualTo(4);
	}

	@Test
	public void testUpdate() {
		assertThat(service.findAll().get(0).getTitre()).isEqualTo("Titre sondage 1");
		Sondage s = service.findAll().get(0);
		s.setTitre("JUNIT TEST");
		service.update(s);
		assertThat(service.findAll().get(0).getTitre()).isEqualTo("JUNIT TEST");
	}

	@Test
	public void testDelete() {
		assertThat(service.findAll().size()).isEqualTo(4);
		Sondage s = new Sondage();
		s.setId(1L);
		service.delete(s);
		assertThat(service.findAll().size()).isEqualTo(3);
	}

}
