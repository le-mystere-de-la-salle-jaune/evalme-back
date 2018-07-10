package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.metiers.QuizzService;

@Controller
@RequestMapping("/quizzes")
public class QuizzController {

	private QuizzService quizzService;

	public QuizzController(QuizzService quizzService) {
		super();
		this.quizzService = quizzService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeQuizz", quizzService.lister());
		mv.setViewName("quizzes/listerQuizz");
		return mv;
	}
}