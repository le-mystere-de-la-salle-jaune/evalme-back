package dev.repositories.examen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.DataJpaTestConfig;
import dev.repositories.examen.reponse.ExamenReponseRepository;

@ContextConfiguration(classes = { ExamenRepositoryDataJpa.class, DataJpaTestConfig.class })
@RunWith(SpringRunner.class)
public class ExamenReponseServiceTest {

	@Autowired
	private ExamenReponseRepository examenReponseRepository;

	@Test
	public void save_test() {

	}

}
