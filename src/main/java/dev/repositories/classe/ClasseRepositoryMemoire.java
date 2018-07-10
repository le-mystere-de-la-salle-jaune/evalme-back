package dev.repositories.classe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import dev.entites.Classe;

@Repository
public class ClasseRepositoryMemoire implements ClasseRepository {

	private List<Classe> classes = new ArrayList();

	@PostConstruct
	public void initialiser() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdd/jdd-Classe.xml")) {
			Classe classe1 = context.getBean("c1", Classe.class);
			Classe classe2 = context.getBean("c2", Classe.class);
			Classe classe3 = context.getBean("c3", Classe.class);

			classe1.setId(1L);
			classe1.setId(2L);
			classe1.setId(3L);

			classes.add(classe1);
			classes.add(classe2);
			classes.add(classe3);

		}

	}

	@Override
	public List<Classe> findAll() {

		return classes;
	}

	@Override
	public void save(Classe classe) {

		classes.add(classe);

	}

	@Override
	public void update(Classe classeAvecId) {

		Classe classe = null;
		for (Classe c : classes) {
			if (classeAvecId.getId() == c.getId()) {
				classe = c;
			}
		}

		if (classe != null) {
			classe.setNom(classeAvecId.getNom());
			classe.setStagiaires(classeAvecId.getStagiaires());
		}
	}

	@Override
	public void delete(Classe classe) {

		int i = 0;
		for (Classe c : classes) {
			if (classe.getId() == c.getId()) {
				classes.remove(i);
			}
			i++;
		}

	}

}
