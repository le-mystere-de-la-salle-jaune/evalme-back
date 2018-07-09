package dev.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.entites.Utilisateur;

@Service
public class UtilisateurServiceMemoire implements UtilisateurService {

	private List<Utilisateur> utilisateurs = new ArrayList<>();

	/**
	 * Initialiser la liste des entites
	 */
	@PostConstruct
	public void initialiser() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdd/jdd-utilisateur.xml")) {
			// examens.add(context.getBean("exam1", Examen.class));
			HashMap<String, Utilisateur> allUtils = (HashMap<String, Utilisateur>) context
					.getBeansOfType(Utilisateur.class);

			for (HashMap.Entry<String, Utilisateur> entry : allUtils.entrySet()) {
				utilisateurs.add(entry.getValue());
			}
		}
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurs;
	}

	@Override
	public void save(Utilisateur entite) {
		utilisateurs.add(entite);

	}

	@Override
	public void update(Utilisateur entiteAvecId) {
		for (Utilisateur util : utilisateurs) {
			if (util.getId() == entiteAvecId.getId()) {
				utilisateurs.set(utilisateurs.indexOf(util), entiteAvecId);
			}
		}

	}

	@Override
	public void delete(Utilisateur entite) {
		if (utilisateurs.contains(entite)) {
			utilisateurs.remove(entite);
		}

	}

}
