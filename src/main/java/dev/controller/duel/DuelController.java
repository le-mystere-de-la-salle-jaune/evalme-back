package dev.controller.duel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.metiers.DuelService;

@Controller
@RequestMapping("/duels")
public class DuelController {

	private DuelService duelService;

	public DuelController(DuelService duelService) {
		super();
		this.duelService = duelService;
	}

	@GetMapping("/lister")
	public ModelAndView lister() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("listeDuels", duelService.lister());
		mav.setViewName("duels/listerDuels");
		return mav;
	}
}
