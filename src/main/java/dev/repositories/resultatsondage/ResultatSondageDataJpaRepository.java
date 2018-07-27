package dev.repositories.resultatsondage;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.ResultatSondage;

public interface ResultatSondageDataJpaRepository extends JpaRepository<ResultatSondage, Long> {

}
