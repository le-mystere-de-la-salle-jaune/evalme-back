package dev.repositories.question;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Question;

public interface QuestionDataJpaRepo extends JpaRepository<Question, Long> {

}
