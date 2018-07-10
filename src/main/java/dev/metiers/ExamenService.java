package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Examen;
import dev.repositories.examen.ExamenRepository;

@Service
public class ExamenService {

	private ExamenRepository examenRepository;

	public ExamenService(ExamenRepository examenRepository) {
		super();
		this.examenRepository = examenRepository;
	}

	public List<Examen> lister() {
		return examenRepository.findAll();
	}

	public void ajouter(Examen examToAdd) {
		examenRepository.save(examToAdd);
	}

}
