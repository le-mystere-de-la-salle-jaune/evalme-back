package dev.controller.api.duel;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import dev.controller.api.viewModels.duel.DuelVm;
import dev.entites.Duel;
import dev.metiers.DuelService;
import dev.metiers.QuizzService;
import dev.metiers.StagiaireService;
import dev.metiers.api.duel.DuelVmService;
import dev.repositories.duel.DuelRepository;

@RestController("/api/duels")
public class DuelApiController {

	private DuelService duelService;
	private DuelVmService duelVmService;

	private StagiaireService stagiaireService;
	private QuizzService quizzService;

	/**
	 * Constructeur
	 * 
	 * @param duelService
	 * @param duelVmService
	 * @param stagiaireService
	 * @param quizzService
	 */
	public DuelApiController(DuelService duelService, DuelVmService duelVm, StagiaireService stagiaireService,
			QuizzService quizzService) {
		super();
		this.duelService = duelService;
		this.duelVmService = duelVm;
		this.stagiaireService = stagiaireService;
		this.quizzService = quizzService;
	}

	@GetMapping("/duels")
	public ResponseEntity<List<DuelVm>> lister() {
		return ResponseEntity.ok(duelVmService.listAllDuel());
	}

	@PostMapping("/duels")
	public ResponseEntity<Duel> ajouter(@RequestParam("stagiaireA_id") Long stagiaireAId,
			@RequestParam("stagiaireB_id") Long stagiaireBId, @RequestParam("quizz_id") Long quizzId) throws Exception {
		Duel duel = new Duel();
		duel.setStagiaireA(stagiaireService.findStagiaireById(stagiaireAId));
		duel.setStagiaireB(stagiaireService.findStagiaireById(stagiaireAId));
		duel.setQuizz(quizzService.findQuizzById(quizzId).orElseThrow(Exception::new));
		// this.duelService.creer(idsStagiaires, quizz); ????????

		URI uri = MvcUriComponentsBuilder
				.fromMethodCall(MvcUriComponentsBuilder.on(DuelRepository.class).findById(duel.getId())).build()
				.encode().toUri();

		return ResponseEntity.created(uri).body(duel);
	}

	@GetMapping("/duels/{id}")
	public ResponseEntity<Duel> afficherDuel(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(this.duelService.getById(id));
	}

}
