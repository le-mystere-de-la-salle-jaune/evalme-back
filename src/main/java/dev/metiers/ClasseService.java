package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Classe;
import dev.repositories.classe.ClasseRepository;

@Service
public class ClasseService {

	private ClasseRepository classeRepository;

	public ClasseService(ClasseRepository classeRepository) {
		super();
		this.classeRepository = classeRepository;
	}

	public List<Classe> lister() {
		return classeRepository.findAll();
	}
<<<<<<< HEAD
=======

	public void ajouter(Classe classe) {
		classeRepository.save(classe);
	}

	public void maj() {
	}

	public void supprimer() {
	}

>>>>>>> avancement
}
