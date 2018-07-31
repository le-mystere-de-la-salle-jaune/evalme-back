package dev.controller.api.resultatsDuels;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/resultats-duels")
@CrossOrigin
public class ResultatDuelApiController {

	@GetMapping
	public ResponseEntity<List<ResultatDuelVm>> lister() {
		List<ResultatDuelVm> resultats = new ArrayList<>();
		ResultatDuelVm r1 = new ResultatDuelVm();
		r1.setId(1L);
		r1.setTitreQuizz("spring");
		r1.setAdversaire(new AdversaireVm(1L, "MONET", "Marion", 13L));
		r1.setScore(15L);
		resultats.add(r1);

		ResultatDuelVm r2 = new ResultatDuelVm();
		r2.setId(2L);
		r2.setTitreQuizz("angular");
		r2.setAdversaire(new AdversaireVm(2L, "BRAVE", "Jean", 19L));
		r2.setScore(15L);
		resultats.add(r2);

		return ResponseEntity.ok(resultats);

	}

}
