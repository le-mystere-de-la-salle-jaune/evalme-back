package dev.paie.services;

import org.springframework.stereotype.Component;

import dev.entites.Question;
import dev.services.CrudService;

@Component
public interface QuestionService extends CrudService<Question> {

}
