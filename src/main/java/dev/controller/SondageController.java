package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.metiers.SondageService;

@Controller
@RequestMapping("/sondages")
public class SondageController {

	private SondageService sondageService;

	public SondageController(SondageService sondageService) {
		super();
		this.sondageService = sondageService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeSondages", sondageService.lister());
		mv.setViewName("sondages/listerSondages");
		return mv;
	}
}
