package dev.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.entites.OptionQuestion;
import dev.entites.Question;
import dev.metiers.OptionQuestionService;
import dev.metiers.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	private QuestionService questionService;
	private OptionQuestionService optionQuestionService;

	public QuestionController(QuestionService questionService, OptionQuestionService optionQuestionService) {
		super();
		this.questionService = questionService;
		this.optionQuestionService = optionQuestionService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeQuestions", questionService.lister());
		mv.setViewName("questions/listerQuestions");
		return mv;
	}

	@GetMapping("/creer")
	public ModelAndView creerQuestion() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeOptions", optionQuestionService.lister());
		mv.addObject("question", new Question("0", "?"));
		mv.setViewName("questions/creerQuestions");
		return mv;
	}

	@PostMapping("/creer")
	public ModelAndView postCreerOption(@ModelAttribute("question") Question question,
			@RequestParam String[] choixOptions, BindingResult result) {
		questionService.getQuestionRepository().save(question);
		ArrayList<OptionQuestion> maList = new ArrayList<OptionQuestion>();
		for (String option : choixOptions) {
			maList.add(optionQuestionService.trouverAvecId(option));
		}
		question.setOptions(maList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeOptions", optionQuestionService.lister());
		mv.setViewName("questions/creerQuestions");
		return mv;
	}

	@GetMapping("/maj")
	public ModelAndView majOption() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeQuestions", questionService.lister());
		mv.addObject("listeOptions", optionQuestionService.lister());
		mv.addObject("question", new Question("0", "?"));
		mv.setViewName("questions/majQuestions");
		return mv;
	}

	@PostMapping("/maj")
	public ModelAndView postMajOption(@ModelAttribute("question") Question question, @RequestParam String choix,
			@RequestParam String[] choixOptions, BindingResult result) {

		ArrayList<OptionQuestion> maList = new ArrayList<OptionQuestion>();
		for (String option : choixOptions) {
			maList.add(optionQuestionService.trouverAvecId(option));
		}
		question.setOptions(maList);

		question.setId(Long.parseLong(choix));
		questionService.getQuestionRepository().update(question);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeQuestions", questionService.lister());
		mv.addObject("listeOptions", optionQuestionService.lister());
		mv.setViewName("questions/majQuestions");
		return mv;
	}

}
