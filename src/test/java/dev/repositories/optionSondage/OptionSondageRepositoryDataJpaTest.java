package dev.repositories.optionSondage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.DataJpaTestConfig;
import dev.entites.OptionSondage;
import dev.repositories.optionsondage.OptionSondageDataJpaRepository;
import dev.repositories.optionsondage.OptionSondageRepositoryDataJpa;

@ContextConfiguration(classes = { OptionSondageRepositoryDataJpa.class, DataJpaTestConfig.class })
@RunWith(SpringRunner.class)
public class OptionSondageRepositoryDataJpaTest {

	@Autowired
	private OptionSondageDataJpaRepository optionSondageRepositoryDataJpa;

	@Test
	public void testFindAll() {
		List<OptionSondage> options = optionSondageRepositoryDataJpa.findAll();
		assertThat(options.size()).isGreaterThan(0);
	}

	@Test
	public void testSave() {

	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {

	}
}
