package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		System.out.println(classeService.lister().get(0).getId());
		System.out.println(classeService.lister().get(1).getId());
		System.out.println(classeService.lister().get(2).getId());
		return mv;
	}

}