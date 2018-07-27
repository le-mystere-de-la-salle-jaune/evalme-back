package dev.repositories.resultatsondage;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.entites.ResultatSondage;

@Repository
public class ResultatSondageRepositoryDataJpa implements ResultatSondageRepository {

	private ResultatSondageDataJpaRepository resultatSondageDataJpa;

	public ResultatSondageRepositoryDataJpa(ResultatSondageDataJpaRepository sondageDataJpa) {
		super();
		this.resultatSondageDataJpa = sondageDataJpa;
	}

	@Override
	public List<ResultatSondage> findAll() {
		// TODO Auto-generated method stub
		return resultatSondageDataJpa.findAll();
	}

	@Override
	public void save(ResultatSondage entite) {
		// TODO Auto-generated method stub
		resultatSondageDataJpa.save(entite);
	}

	@Override
	public void update(ResultatSondage entiteAvecId) {
		// TODO Auto-generated method stub
		resultatSondageDataJpa.save(entiteAvecId);
	}

	@Override
	public void delete(ResultatSondage entite) {
		// TODO Auto-generated method stub
		resultatSondageDataJpa.delete(entite);
	}

	@Override
	public Optional<ResultatSondage> findById(Long id) {
		// TODO Auto-generated method stub
		return resultatSondageDataJpa.findById(id);
	}

}
