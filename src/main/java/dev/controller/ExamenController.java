package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.entites.Classe;
import dev.entites.Examen;
import dev.entites.Quizz;
import dev.metiers.ClasseService;
import dev.metiers.ExamenService;
import dev.metiers.QuizzService;

@Controller
@RequestMapping("/examens")
public class ExamenController {

	private ExamenService examenService;
	private QuizzService quizzService;
	private ClasseService classeService;

	public ExamenController(ExamenService examenService, QuizzService quizzService, ClasseService classeService) {
		super();
		this.examenService = examenService;
		this.quizzService = quizzService;
		this.classeService = classeService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("examList", examenService.lister());
		mv.setViewName("examens/listerExamens");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ajouter")
	public ModelAndView ajouter() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("examen", new Examen());
		mv.addObject("quizzList", quizzService.lister());
		mv.addObject("classeList", classeService.lister());
		mv.setViewName("examens/ajouterExamen");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ajouter")
	public String submitForm(@ModelAttribute("examen") Examen exam) {
		for (Quizz q : quizzService.lister()) {
			if (q.getId() == exam.getQuizz().getId()) {
				exam.setQuizz(q);
			}
		}

		for (Classe c : classeService.lister()) {
			if (c.getId() == exam.getClasse().getId()) {
				exam.setClasse(c);
			}
		}
		examenService.ajouter(exam);
		return "redirect:/examens/lister";
	}
}
