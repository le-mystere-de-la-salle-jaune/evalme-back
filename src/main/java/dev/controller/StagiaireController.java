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
		s.setNom(s.getNom());
		s.setPrenom(s.getPrenom());
		s.setEmail(s.getEmail());
		s.setPhotoUrl(s.getPhotoUrl());
		mv.addObject("stagiaire", s);
		// si erreur renvoyer le formulaire avec les erreurs
		mv.setViewName("stagiaires/creerStagiaires");
		// si tout est ok il faut sauvegarder dans service;
		mv.setViewName("redictect:/lister");
		return mv;
	}

	/*
	 * @GetMapping("/update") public ModelAndView update() { ModelAndView mv =
	 * new ModelAndView(); mv.addObject("listeStagiaires",
	 * stagiaireService.update());
	 * mv.setViewName("stagiaires/updateStagiaires"); return mv; }
	 *
	 * @GetMapping("/delete") public ModelAndView delete() { ModelAndView mv =
	 * new ModelAndView(); mv.addObject("listeStagiaires",
	 * stagiaireService.delete());
	 * mv.setViewName("stagiaires/deleteStagiaires"); return mv; }
	 */

}
