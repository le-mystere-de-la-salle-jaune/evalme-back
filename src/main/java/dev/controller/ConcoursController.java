package dev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.entites.Concours;
import dev.entites.Quizz;
import dev.entites.Stagiaire;
import dev.metiers.ConcoursService;
import dev.metiers.QuizzService;
import dev.metiers.StagiaireService;

@Controller
@RequestMapping("/concours")
public class ConcoursController {

	private ConcoursService concoursService;
	private StagiaireService stagiaireService;
	private QuizzService quizzService;

	public ConcoursController(ConcoursService concoursService, StagiaireService stagiaireService,
			QuizzService quizzService) {
		super();
		this.concoursService = concoursService;
		this.stagiaireService = stagiaireService;
		this.quizzService = quizzService;
	}

	/*
	 * public ConcoursController(ConcoursService concoursService) { super();
	 * this.concoursService = concoursService; }
	 */

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeConcours", concoursService.list());
		mv.setViewName("concours/listerConcours");
		return mv;
	}

	@GetMapping("/creer")
	public ModelAndView save() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("concours", new Concours());
		mv.addObject("participants", stagiaireService.lister());
		mv.addObject("quizzes", quizzService.lister());
		mv.setViewName("concours/creerConcours");
		return mv;
	}

	@PostMapping("/creer")
	public ModelAndView postForm(@ModelAttribute("concours") @Valid Concours c, BindingResult result,
			@RequestParam List<Long> quizzes, @RequestParam List<String> participants) {
		ModelAndView mv = new ModelAndView();
		List<Quizz> listequizz = new ArrayList<>();
		List<Stagiaire> listeparticipant = new ArrayList<>();
		if (!c.getTitre().isEmpty()) {
			if (!quizzes.isEmpty()) {
				for (Quizz q : quizzService.lister()) {
					for (long i : quizzes) {
						if (i == q.getId()) {
							listequizz.add(q);
						}
					}
				}

			}
			;
			c.setQuizzes(listequizz);

			if (!participants.isEmpty()) {
				for (Stagiaire q : stagiaireService.lister()) {
					for (String i : participants) {
						if (q.getEmail().equals(i)) {
							listeparticipant.add(q);
						}
					}
				}

			}
			;
			c.setParticipants(listeparticipant);
			// si tout est ok il faut sauvegarder dans service;
			mv.setViewName("redirect:/concours/lister");
			concoursService.ajout(c);

		} else {
			// si erreur renvoyer le formulaire avec les erreurs
			mv.setViewName("concours/creerConcours");
		}

		return mv;
	}

	@GetMapping("/editer")
	public ModelAndView Formmaj(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("participants", stagiaireService.lister());
		mv.addObject("quizzes", quizzService.lister());
		mv.addObject("concours", concoursService.FindbyId(id));
		mv.setViewName("concours/creerConcours");
		return mv;
	}

	@PostMapping("/editer")
	public ModelAndView editerForm(@ModelAttribute("concours") @Valid Concours c, BindingResult result,
			@RequestParam List<Long> quizzes, @RequestParam List<String> participants) {
		ModelAndView mv = new ModelAndView();
		List<Quizz> listequizz = new ArrayList<>();
		List<Stagiaire> listeparticipant = new ArrayList<>();
		if (!c.getTitre().isEmpty()) {
			if (!quizzes.isEmpty()) {
				for (Quizz q : quizzService.lister()) {
					for (long i : quizzes) {
						if (i == q.getId()) {
							listequizz.add(q);
						}
					}
				}

			}
			;
			c.setQuizzes(listequizz);

			if (!participants.isEmpty()) {
				for (Stagiaire q : stagiaireService.lister()) {
					for (String i : participants) {
						if (q.getEmail().equals(i)) {
							listeparticipant.add(q);
						}
					}
				}

			}
			;
			c.setParticipants(listeparticipant);
			// si tout est ok il faut sauvegarder dans service;
			mv.setViewName("redirect:/concours/lister");
			concoursService.miseajour(c);

		} else {
			// si erreur renvoyer le formulaire avec les erreurs
			mv.addObject("participants", stagiaireService.lister());
			mv.addObject("quizzes", quizzService.lister());
			mv.setViewName("concours/creerConcours");
		}

		return mv;
	}

	@GetMapping("/supprimer")
	public ModelAndView Formsup(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		concoursService.suppression(concoursService.FindbyId(id));
		mv.setViewName("redirect:/concours/lister");
		return mv;
	}

}
