package dev.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.entites.Examen;

@Service
public class ExamenServiceMemoire_old implements ExamenService {

	private List<Examen> examens = new ArrayList<>();

	/**
	 * Initialiser la liste des entites
	 */
	@PostConstruct
	public void initialiser() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdd/jdd-examens.xml")) {

			context.getBeansOfType(Examen.class).forEach((k, v) -> examens.add(v));
		}
	}

	@Override
	public List<Examen> findAll() {
		return examens;
	}

	@Override
	public void save(Examen entite) {
		examens.add(entite);

	}

	@Override
	public void update(Examen entiteAvecId) {

		for (Examen exam : examens) {
			if (exam.getId() == entiteAvecId.getId()) {
				examens.set(examens.indexOf(exam), entiteAvecId);
			}
		}
	}

	@Override
	public void delete(Examen entite) {
		if (examens.contains(entite)) {
			examens.remove(entite);
		}

	}

}
