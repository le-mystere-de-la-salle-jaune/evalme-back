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

import dev.entites.Duel;
import dev.repositories.duel.DuelRepository;
import dev.repositories.quizz.QuizzRepository;
import dev.repositories.stagiaire.StagiaireRepository;

@RestController("/api")
public class DuelApiController {

	private DuelRepository duelRepository;
	private StagiaireRepository stagiaireRepository;
	private QuizzRepository quizzRepository;

	/**
	 * Constructeur
	 * 
	 * @param duelService
	 * @param stagiaireRepository
	 * @param quizzRepository
	 */
	public DuelApiController(DuelRepository duelRepository, StagiaireRepository stagiaireRepository,
			QuizzRepository quizzRepository) {
		super();
		this.duelRepository = duelRepository;
		this.stagiaireRepository = stagiaireRepository;
		this.quizzRepository = quizzRepository;
	}

	@GetMapping("/duels")
	public ResponseEntity<List<Duel>> lister() {
		List<Duel> duels = this.duelRepository.findAll();
		return ResponseEntity.ok(duels);
	}

	@PostMapping("/duels")
	public ResponseEntity<Duel> ajouter(@RequestParam("stagiaireA_id") Long stagiaireAId,
			@RequestParam("stagiaireB_id") Long stagiaireBId, @RequestParam("quizz_id") Long quizzId) throws Exception {
		Duel duel = new Duel();
		duel.setStagiaireA(stagiaireRepository.findById(stagiaireAId).orElseThrow(Exception::new));
		duel.setStagiaireB(stagiaireRepository.findById(stagiaireBId).orElseThrow(Exception::new));
		duel.setQuizz(quizzRepository.findById(quizzId).orElseThrow(Exception::new));
		this.duelRepository.save(duel);

		URI uri = MvcUriComponentsBuilder
				.fromMethodCall(MvcUriComponentsBuilder.on(DuelRepository.class).findById(duel.getId())).build()
				.encode().toUri();

		return ResponseEntity.created(uri).body(duel);
	}

	@GetMapping("/duels/{id}")
	public ResponseEntity<Duel> afficherDuel(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(this.duelRepository.findById(id).orElseThrow(Exception::new));
	}

}
