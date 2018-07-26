package dev.repositories.examen.reponse;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.entites.ExamenReponse;

@Repository
public class ExamenReponseDataJpa implements ExamenReponseRepository {

	private IExamenReponseDataJpa examenResponse;

	public ExamenReponseDataJpa(IExamenReponseDataJpa examenResponse) {
		super();
		this.examenResponse = examenResponse;
	}

	@Override
	public List<ExamenReponse> findAll() {
		return examenResponse.findAll();
	}

	@Override
	public void save(ExamenReponse entite) {
		examenResponse.save(entite);

	}

	@Override
	public void update(ExamenReponse entiteAvecId) {
		examenResponse.save(entiteAvecId);
	}

	@Override
	public void delete(ExamenReponse entite) {
		examenResponse.delete(entite);
	}

	@Override
	public Optional<ExamenReponse> findById(Long id) {
		return null;
	}

}
