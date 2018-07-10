package dev.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.entites.Stagiaire;
import dev.metiers.StagiaireService;

@Controller
@RequestMapping("/stagiaires")
public class StagiaireController {

	private StagiaireService stagiaireService;

	public StagiaireController(StagiaireService stagiaireService) {
		super();
		this.stagiaireService = stagiaireService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeStagiaires", stagiaireService.lister());
		mv.setViewName("stagiaires/listerStagiaires");
		return mv;
	}

	@GetMapping("/creer")
	public ModelAndView save() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stagiaire", new Stagiaire());
		mv.setViewName("stagiaires/creerStagiaires");
		return mv;
	}

	@PostMapping("/creer")
	public ModelAndView postForm2(@ModelAttribute("stagiaire") @Valid Stagiaire s, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			// si erreur renvoyer le formulaire avec les erreurs de form error
			mv.addObject("stagiaire", s);
			mv.setViewName("stagiaires/creerStagiaires");
		} else {
			// si tout est ok on sauvegarde le nouveau stagiaire et on redirige
			// vers lister;
			stagiaireService.save(s);
			mv.setViewName("redirect:/stagiaires/lister");
		}
		return mv;
	}
}
