package dev.repositories.concours;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.entites.PassageConcours;

public interface PassageConcoursRepository extends JpaRepository<PassageConcours, Long>{
	
	@Query("select pc from PassageConcours pc where pc.stagiaire.id = :idStagiaire")
    List<PassageConcours> findPassageByStagiaire(@Param("idStagiaire") Long idStagiaire);
	
	@Query("select pc from PassageConcours pc where pc.concours.id = :idConcours")
    List<PassageConcours> findPassageByConcours(@Param("idConcours") Long idConcours);
	
	//@Query("select q from Question q, PassageConcours pc, Quizz quizz where pc.id = :idPassage and pc.concours.")
    //List<Question> getUnansweredQuestions(@Param("idPassage") Long idPassage);

}
