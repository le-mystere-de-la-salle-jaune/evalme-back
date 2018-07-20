package dev.controller.api.viewModels.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping
	public ResponseEntity<ClasseVmAjouter> ajouter(@RequestBody ClasseVmAjouter classeVmAjouter)
			throws Exception {
		Classe classe = new Classe();
		List<StagiaireVm> stagiaires = classeVmAjouter.getStagiairesVmAjouter()
		List<Stagiaire> stagiairesAll = stagiaireRepository.findAll();
		List<Stagiaire> listeStClasse = new ArrayList<>();
		if (!stagiaires.isEmpty()) {
			for (Long id : stagiaires) {
				for (Stagiaire st : stagiairesAll) {
					if (id.equals(st.getId())) {
						listeStClasse.add(st);
					}
				}
			}
		}

		classe.setNom(classeVmAjouter.getNom());
		classe.setStagiaires(listeStClasse);
		this.classeRepository.save(classe);

		return ResponseEntity.status(HttpStatus.OK).body(new ClasseVmAjouter(classe.getId()));
	}

	@GetMapping("/{id}")

	public ResponseEntity<ClasseVmDetail> afficherClasse(@PathVariable Long id) throws Exception {

		Optional<Classe> classe = this.classeRepository.findById(id);

		ClasseVmDetail classesVm = new ClasseVmDetail(classe);

		return ResponseEntity.status(HttpStatus.OK).body(classesVm);
	}
}