package dev.controller.api.duel.viewModels;

public class DuelVm {
	private Long id;
	private StagiaireVm stagiaireA;
	private StagiaireVm stagiaireB;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param stagiaireA
	 * @param stagiaireB
	 */
	public DuelVm(Long id, StagiaireVm stagiaireA, StagiaireVm stagiaireB) {
		super();
		this.id = id;
		this.stagiaireA = stagiaireA;
		this.stagiaireB = stagiaireB;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the stagiaireA
	 */
	public StagiaireVm getStagiaireA() {
		return stagiaireA;
	}

	/**
	 * @param stagiaireA
	 *            the stagiaireA to set
	 */
	public void setStagiaireA(StagiaireVm stagiaireA) {
		this.stagiaireA = stagiaireA;
	}

	/**
	 * @return the stagiaireB
	 */
	public StagiaireVm getStagiaireB() {
		return stagiaireB;
	}

	/**
	 * @param stagiaireB
	 *            the stagiaireB to set
	 */
	public void setStagiaireB(StagiaireVm stagiaireB) {
		this.stagiaireB = stagiaireB;
	}

}
