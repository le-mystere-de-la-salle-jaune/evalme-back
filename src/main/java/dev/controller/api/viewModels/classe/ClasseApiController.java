package dev.controller.api.viewModels.classe;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import dev.entites.Classe;
import dev.entites.Stagiaire;
import dev.repositories.classe.ClasseRepository;
import dev.repositories.stagiaire.StagiaireRepository;

@RestController("/api/classes")
@RequestMapping(value = "/api/classes")
public class ClasseApiController {

	private ClasseRepository classeRepository;
	private StagiaireRepository stagiaireRepository;

	public ClasseApiController(ClasseRepository classeRepository, StagiaireRepository stagiaireRepository) {
		super();
		this.classeRepository = classeRepository;
		this.stagiaireRepository = stagiaireRepository;
	}

	@GetMapping
	public ResponseEntity<List<ClasseVmLister>> lister() {
		List<Classe> classes = this.classeRepository.findAll();

		List<ClasseVmLister> classesVm = classes.stream().map(uneClasse -> new ClasseVmLister(uneClasse))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(classesVm);
	}

	@PostMapping("/ajouter")
	public ResponseEntity<Classe> ajouter(@RequestParam("nom") String nomClasse,
			@RequestParam("stagiaires") List<Stagiaire> stagiairesClasse) throws Exception {
		Classe classe = new Classe();
		classe.setNom(nomClasse);
		classe.setStagiaires(stagiairesClasse);
		this.classeRepository.save(classe);

		URI uri = MvcUriComponentsBuilder
				.fromMethodCall(MvcUriComponentsBuilder.on(ClasseRepository.class).findById(classe.getId())).build()
				.encode().toUri();

		return ResponseEntity.created(uri).body(classe);
	}

	@GetMapping("/{id}")

	public ResponseEntity<ClasseVmDetail> afficherClasse(@PathVariable Long id) throws Exception {

		Optional<Classe> classe = this.classeRepository.findById(id);

		ClasseVmDetail classesVm = new ClasseVmDetail(classe);

		return ResponseEntity.status(HttpStatus.OK).body(classesVm);
	}
}