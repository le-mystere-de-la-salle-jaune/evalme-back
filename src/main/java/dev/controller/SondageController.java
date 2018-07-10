package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.metiers.ClasseService;
import dev.metiers.SondageService;

@Controller
@RequestMapping("/sondages")
public class SondageController {

	private SondageService sondageService;
	private ClasseService classeService;

	public SondageController(SondageService sondageService, ClasseService classeService) {
		super();
		this.sondageService = sondageService;
		this.classeService = classeService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeSondages", sondageService.lister());
		mv.setViewName("sondages/listerSondages");
		return mv;
	}

	@GetMapping("/ajouter")
	public ModelAndView save() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeClasse", classeService.lister());
		mv.setViewName("sondages/ajouterSondage");
		return mv;
	}
	/*
	 * @GetMapping("/update") public ModelAndView update() { ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("sondages/updateSondage"); return mv;
	 * }
	 * 
	 * @GetMapping("/delete") public ModelAndView delete() { ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("sondages/deleteSondage"); return mv;
	 * }
	 */
}
