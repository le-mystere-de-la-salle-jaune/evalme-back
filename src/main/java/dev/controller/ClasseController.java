package dev.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.entites.Classe;
import dev.metiers.ClasseService;

@Controller
@RequestMapping("/classes")
public class ClasseController {
	private ClasseService classeService;

	public ClasseController(ClasseService classeService) {
		super();
		this.classeService = classeService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeClasses", classeService.lister());
		mv.setViewName("classes/listerClasses");
		return mv;
	}

	@GetMapping("/ajouter")
	public ModelAndView save() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("classe", new Classe());
		mv.setViewName("classes/ajouterClasses");
		return mv;
	}

	@PostMapping("/ajouter")
	public ModelAndView postForm2(@ModelAttribute("classe") @Valid Classe c, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		c.setNom(c.getNom());
		c.setStagiaires(c.getStagiaires());
		mv.addObject("classe", c);
		// si erreur renvoyer le formulaire avec les erreurs
		mv.setViewName("classes/ajouterClasses");
		// si tout est ok il faut sauvegarder dans service;
		mv.setViewName("redictect:/lister");
		return mv;
	}

}
