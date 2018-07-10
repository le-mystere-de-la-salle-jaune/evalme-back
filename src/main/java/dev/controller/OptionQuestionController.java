package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.entites.OptionQuestion;
import dev.metiers.OptionQuestionService;

@Controller
@RequestMapping("/questions")
public class OptionQuestionController {

	private OptionQuestionService optionQuestionService;

	public OptionQuestionController(OptionQuestionService optionQuestionService) {
		super();
		this.optionQuestionService = optionQuestionService;
	}

	@GetMapping("/listerOption")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeOptionQuestions", optionQuestionService.lister());
		mv.setViewName("questions/listerOptionQuestions");
		return mv;
	}

	@GetMapping("/creerOption")
	public ModelAndView creerOption() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("questions/creerOptionQuestions");
		return mv;
	}

	@PostMapping("/creerOption")
	public ModelAndView postCreerOption(@RequestParam String id, @RequestParam String libelle,
			@RequestParam String ok) {
		OptionQuestion newOption = new OptionQuestion();
		newOption.setId(Long.parseLong(id));
		newOption.setLibelle(libelle);
		newOption.setOk(Boolean.valueOf(ok));
		optionQuestionService.lister().add(newOption);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("questions/creerOptionQuestions");
		return mv;
	}

}
