package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
