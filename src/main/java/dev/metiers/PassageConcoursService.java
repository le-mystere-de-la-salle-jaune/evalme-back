package dev.metiers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.api.viewModels.passageConcours.PassageConcoursVm;
import dev.controller.api.viewModels.passageConcours.ResultatConcoursVm;
import dev.entites.Concours;
import dev.entites.PassageConcours;
import dev.entites.Stagiaire;
import dev.repositories.concours.PassageConcoursRepository;
import dev.repositories.concours.ResultatQuestionConcoursRepository;

@Service
public class PassageConcoursService {

	private PassageConcoursRepository passageConcoursRepository;
	private ResultatQuestionConcoursRepository resultatQuestionConcoursRepository;

	public PassageConcoursService(PassageConcoursRepository passageConcoursRepository, ResultatQuestionConcoursRepository resultatQuestionConcoursRepository) {
		super();
		this.passageConcoursRepository = passageConcoursRepository;
		this.resultatQuestionConcoursRepository = resultatQuestionConcoursRepository;
	}

	public Long createPassage(PassageConcoursVm passageConcoursVm) {
		
		PassageConcours tempPassage = new PassageConcours();
		tempPassage.setConcours(new Concours(passageConcoursVm.getConcours()));
		tempPassage.setStagiaire(new Stagiaire(passageConcoursVm.getStagiaire()));
		tempPassage.setDatePassage(LocalDateTime.now());
		tempPassage.setScore(null);
		
		passageConcoursRepository.save(tempPassage);
		
		return tempPassage.getId();
		
	}
	
	public List<ResultatConcoursVm> getResultatByStagiaire(Long idStagiaire){
		
		List<ResultatConcoursVm> returnArray = new ArrayList<>();
		int i =0;
		
		for(PassageConcours ps : passageConcoursRepository.findPassageByStagiaire(idStagiaire)){
			returnArray.add(new ResultatConcoursVm(ps.getId(), ps.getConcours().getId(), ps.getConcours().getTitre(), getRank(ps.getId())));
		}
		
		return returnArray;
	}
	
	@Transactional
	public void saveNote(Long idPassage,int score){
		passageConcoursRepository.findById(idPassage).orElse(null).setScore(new Integer(score));
	}
	
	public int getRank(Long idPassage){
		
		PassageConcours temp = passageConcoursRepository.findById(idPassage).orElse(null);
		Long idConcours = temp.getConcours().getId();
		
		List<PassageConcours> listePassage = passageConcoursRepository.findPassageByConcours(idConcours);
	
		
		return listePassage.stream().sorted(Comparator.comparing(PassageConcours::getScore)).collect(Collectors.toList()).indexOf(temp)+1;

	}

	
}
