package dev.controller.api.sondage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.api.sondage.viewModels.ClasseListerSondageVM;
import dev.controller.api.sondage.viewModels.ListerSondageVM;
import dev.controller.api.sondage.viewModels.OptionListerSondageVM;
import dev.controller.api.sondage.viewModels.SondageByIdVM;
import dev.entites.OptionSondage;
import dev.entites.Sondage;
import dev.metiers.SondageService;
import dev.metiers.StagiaireService;

@Service
public class SondageBuilder {

	private SondageService sondageService;
	private StagiaireService stagiaireService;

	public SondageBuilder(SondageService sondageService, StagiaireService stagiaireService) {
		super();
		this.sondageService = sondageService;
		this.stagiaireService = stagiaireService;
	}

	@Transactional
	public List<ListerSondageVM> creerJsonLister() {
		List<ListerSondageVM> listeSondage = new ArrayList<>();
		List<Sondage> sondages = sondageService.lister();
		for (Sondage s : sondages) {
			ListerSondageVM ls = new ListerSondageVM();
			ClasseListerSondageVM classe = new ClasseListerSondageVM();
			classe.setId(s.getClasse().getId());
			classe.setNom(s.getClasse().getNom());
			ls.setId(s.getId());
			ls.setTitre(s.getTitre());
			ls.setClasse(classe);
			ls.setNb_options(s.getOptions().size());
			listeSondage.add(ls);
		}
		return listeSondage;
	}

	@Transactional
	public SondageByIdVM creerJsonListerById(Long id) throws Exception {
		List<Sondage> sondages = sondageService.lister();
		Sondage s = sondageService.findById(id);

		ClasseListerSondageVM classe = new ClasseListerSondageVM();
		classe.setId(s.getClasse().getId());
		classe.setNom(s.getClasse().getNom());

		List<OptionListerSondageVM> options = new ArrayList<>();

		for (OptionSondage os : s.getOptions()) {
			OptionListerSondageVM option = new OptionListerSondageVM();
			option.setId(os.getId());
			option.setLibelle(os.getLibelle());
			option.setDescription(os.getDescription());
			options.add(option);
		}

		SondageByIdVM sondageVM = new SondageByIdVM();
		sondageVM.setId(s.getId());
		sondageVM.setTitre(s.getTitre());
		sondageVM.setClasse(classe);
		sondageVM.setOptions(options);

		return sondageVM;
	}

	@Transactional
	public Optional<List<ListerSondageVM>> creerJsonListerByIdStagiaire(Long idStagiaire) throws Exception {

		return this.stagiaireService.findStagiaireById(idStagiaire).map(stagiaire -> {
			return sondageService.lister().stream()
					.filter(sondage -> sondage.getClasse().getId().equals(stagiaire.getClasse().getId()))
					.map(sondage -> new ListerSondageVM(sondage.getId(), sondage.getTitre(),
							new ClasseListerSondageVM(sondage.getClasse().getId(), sondage.getClasse().getNom()),
							sondage.getOptions().size()))
					.collect(Collectors.toList());
		});
	}
}
