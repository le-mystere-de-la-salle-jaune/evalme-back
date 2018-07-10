package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Duel;
import dev.repositories.duel.DuelRepository;

@Service
public class DuelService {

	private DuelRepository duelRepository;

	/**
	 * @param duelRepository
	 */
	public DuelService(DuelRepository duelRepository) {
		super();
		this.duelRepository = duelRepository;
	}

	public void creer(Duel duel) {
		this.duelRepository.save(duel);
	}

	/**
	 * @return
	 */
	public List<Duel> lister() {
		return duelRepository.findAll();
	}

	public void editer(Duel duelAvecId) {
		this.duelRepository.update(duelAvecId);
	}

	public void supprimer(Duel duel) {
		this.duelRepository.delete(duel);
	}

}
