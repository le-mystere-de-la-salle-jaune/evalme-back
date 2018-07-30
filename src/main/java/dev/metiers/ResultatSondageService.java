package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.ResultatSondage;
import dev.repositories.resultatsondage.ResultatSondageRepository;

@Service
public class ResultatSondageService {

	private ResultatSondageRepository resultaltSondageRepository;

	public ResultatSondageService(ResultatSondageRepository sondageRepository) {
		super();
		this.resultaltSondageRepository = sondageRepository;
	}

	public List<ResultatSondage> lister() {
		return resultaltSondageRepository.findAll();
	}

	public void save(ResultatSondage rs) {
		resultaltSondageRepository.save(rs);
	}

	public ResultatSondage findById(Long id) throws Exception {
		return resultaltSondageRepository.findById(id).orElseThrow(Exception::new);
	}

}
