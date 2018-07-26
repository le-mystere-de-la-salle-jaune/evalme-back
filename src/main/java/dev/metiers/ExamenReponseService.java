package dev.metiers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.entites.ExamenReponse;
import dev.repositories.examen.reponse.ExamenReponseRepository;

@Service
public class ExamenReponseService {

	private ExamenReponseRepository examenReponseRepo;

	public ExamenReponseService(ExamenReponseRepository examenReponseRepo) {
		super();
		this.examenReponseRepo = examenReponseRepo;
	}

	public List<ExamenReponse> findAllResultExamenStagiaire(Long idExamen, Long idStagiaire) {
		List<ExamenReponse> reponses = examenReponseRepo.findAll();

		return reponses.stream().filter(
				rep -> (rep.getExamen().getId().equals(idExamen) && rep.getStagiaire().getId().equals(idStagiaire)))
				.map(result -> result).collect(Collectors.toList());
	}

	public void saveResultExamenStagiaireQuestion(ExamenReponse examReponse) {
		examenReponseRepo.save(examReponse);
	}

}
