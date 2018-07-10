package dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.metiers.OptionSondageService;

@Controller
@RequestMapping("/sondage/option")
public class OptionSondageController {

	private OptionSondageService optionSondageService;

	public OptionSondageController(OptionSondageService optionSondageService) {
		super();
		this.optionSondageService = optionSondageService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listeOptionSondage", optionSondageService.lister());
		mv.setViewName("optionSondages/listerOptionSondages");
		return mv;
	}
}
