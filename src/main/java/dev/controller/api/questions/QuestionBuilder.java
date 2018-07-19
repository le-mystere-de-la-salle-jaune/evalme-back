package dev.controller.api.questions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.api.questions.viewModels.ListerQuestionVM;
import dev.controller.api.questions.viewModels.OptionListerQuestionVM;
import dev.controller.api.questions.viewModels.QuestionByIdVM;
import dev.entites.OptionQuestion;
import dev.entites.Question;
import dev.metiers.QuestionService;

@Service
public class QuestionBuilder {

	private QuestionService questionService;

	public QuestionBuilder(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@Transactional
	public List<ListerQuestionVM> creerJsonLister() {
		List<ListerQuestionVM> listeQuestion = new ArrayList<>();
		List<Question> questions = questionService.lister();

		for (Question q : questions) {
			ListerQuestionVM lq = new ListerQuestionVM();
			lq.setId(q.getId());
			lq.setTitre(q.getTitre());
			lq.setNb_option(q.getOptions().size());
			listeQuestion.add(lq);
		}

		return listeQuestion;
	}

	@Transactional
	public QuestionByIdVM creerJsonListerById(long id) throws Exception {

		Question q = questionService.findById(id);

		List<OptionListerQuestionVM> options = new ArrayList<>();

		for (OptionQuestion oq : q.getOptions()) {
			OptionListerQuestionVM option = new OptionListerQuestionVM();
			option.setId(oq.getId());
			option.setLibelle(oq.getLibelle());
			option.setOk(oq.getOk());
			options.add(option);

		}

		QuestionByIdVM questionVM = new QuestionByIdVM();
		questionVM.setId(q.getId());
		questionVM.setTitre(q.getTitre());
		questionVM.setOptions(options);

		return questionVM;

	}

}
