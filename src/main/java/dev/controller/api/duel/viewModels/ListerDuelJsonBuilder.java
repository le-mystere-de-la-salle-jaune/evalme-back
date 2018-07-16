package dev.controller.api.duel.viewModels;

import java.util.List;

import dev.entites.Duel;
import dev.metiers.DuelService;

public class ListerDuelJsonBuilder {
	private List<Duel> listeDuels;

	public DuelService duelService;

	/**
	 * Constructeur
	 * 
	 * @param listeDuels
	 */
	public ListerDuelJsonBuilder(List<Duel> listeDuels) {
		super();
		this.listeDuels = listeDuels;
	}

}
