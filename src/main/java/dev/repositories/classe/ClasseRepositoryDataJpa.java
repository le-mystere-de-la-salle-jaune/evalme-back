package dev.repositories.classe;

import java.util.List;
import java.util.Optional;

import dev.entites.Classe;

public class ClasseRepositoryDataJpa implements ClasseRepository {

	private ClasseDataJpaRepo classeDataJpaRepo;

	public ClasseRepositoryDataJpa(ClasseDataJpaRepo entiteDataJpaRepo) {
		this.classeDataJpaRepo = entiteDataJpaRepo;
	}

	@Override
	public List<Classe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Classe entite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Classe entiteAvecId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Classe entite) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Classe> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
