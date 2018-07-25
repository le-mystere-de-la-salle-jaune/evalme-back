package dev.repositories.concours;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.entites.Concours;

@Repository
public class ConcoursRepositoryDataJpa implements ConcoursRepository {

	private ConcoursDataJpaRepo concoursDataJpaRepo;

	public ConcoursRepositoryDataJpa(ConcoursDataJpaRepo concourDataJpaRepo) {
		this.concoursDataJpaRepo = concourDataJpaRepo;
	}

	@Override
	public List<Concours> findAll() {
		return concoursDataJpaRepo.findAll();
	}

	@Override
	public void save(Concours entite) {
		concoursDataJpaRepo.save(entite);

	}

	@Override
	public void update(Concours entiteAvecId) {
		if (concoursDataJpaRepo.existsById(entiteAvecId.getId())) {
			save(entiteAvecId);
		}
	}

	@Override
	public void delete(Concours entite) {
		concoursDataJpaRepo.delete(entite);

	}

	@Override
	public Optional<Concours> findById(Long id) {
		return concoursDataJpaRepo.findById(id);

	}

}
