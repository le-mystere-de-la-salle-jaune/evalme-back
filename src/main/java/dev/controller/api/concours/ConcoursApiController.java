package dev.controller.api.concours;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.Concours;
import dev.metiers.ConcoursService;

@RestController
@RequestMapping(value = "/concours/lister/api")
public class ConcoursApiController {

	private ConcoursService concoursService;

	public ConcoursApiController(ConcoursService concoursService) {
		super();
		this.concoursService = concoursService;
	}

	// lister
	@GetMapping
	public ResponseEntity<List<ConcoursVm>> findAll() {
		List<Concours> listeConcours = this.concoursService.list();

		List<ConcoursVm> listeConcoursVm = listeConcours.stream().map(unConcours -> new ConcoursVm(unConcours))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(listeConcoursVm);
	}

}
