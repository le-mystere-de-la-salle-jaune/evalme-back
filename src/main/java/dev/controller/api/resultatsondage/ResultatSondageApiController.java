package dev.controller.api.resultatsondage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.ResultatSondage;
import dev.metiers.OptionSondageService;
import dev.metiers.ResultatSondageService;
import dev.metiers.SondageService;
import dev.metiers.StagiaireService;

@RestController
@RequestMapping(value = "/api/resultatsondage")
@CrossOrigin
public class ResultatSondageApiController {

	private ResultatSondageService resultatSondageService;

	private StagiaireService sgservice;

	private OptionSondageService osservice;

	private SondageService sdservice;

	public ResultatSondageApiController(ResultatSondageService resultatSondageService) {
		super();
		this.resultatSondageService = resultatSondageService;
	}

	// lister
	@GetMapping
	public ResponseEntity<List<ResultatSondageVM>> findAll() {
		List<ResultatSondage> listeResultatSondage = this.resultatSondageService.lister();

		List<ResultatSondageVM> listeResultatSondageVm = listeResultatSondage.stream()
				.map(unResultatSondage -> new ResultatSondageVM(unResultatSondage)).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(listeResultatSondageVm);
	}

	// lister par id
	@GetMapping("/{id}")
	public ResponseEntity<List<ResultatSondageVM>> findbyid(@PathVariable Long id) throws Exception {
		List<ResultatSondage> listeResultatSondage = this.resultatSondageService.lister();

		List<ResultatSondageVM> listeResultatSondageVm = listeResultatSondage.stream()
				.filter(element -> element.getStagiaire().getId() == id)
				.map(unResultatSondage -> new ResultatSondageVM(unResultatSondage)).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(listeResultatSondageVm);
	}

	@PostMapping
	public ResponseEntity<ResultatSondage> creer(@RequestBody ResultatSondageVM resultatSondageVm) {
		ResultatSondage resultatsondage = new ResultatSondage();
		resultatsondage.setId(resultatSondageVm.getId());
		try {
			resultatsondage.setOptionSondage(osservice.findById(resultatSondageVm.getOptionSondage()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultatsondage.setSondage(sdservice.findById(resultatSondageVm.getSondage()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultatsondage.setStagiaire(sgservice.findStagiaireById(resultatSondageVm.getStagiaire()));

		return ResponseEntity.status(HttpStatus.OK).body(resultatsondage);

	}

}
