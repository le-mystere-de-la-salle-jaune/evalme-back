package dev.entites;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "passage_concours")
public class PassageConcours extends BaseEntite {
	
	@ManyToOne
	@JoinColumn(name = "id_concours")
	private Concours concours;
	
	@ManyToOne
	@JoinColumn(name = "id_stagiaire")
	private Stagiaire stagiaire;
	
	@Column(name = "date_passage")
	private LocalDateTime datePassage;
	
	@Column(name = "score")
	private Integer score;
	
	@OneToMany(mappedBy="passageConcours")
	private List<ResultatQuestionConcours> listResultatQuestions;
	
	public PassageConcours(){
		
	}
	
	public PassageConcours(Long id){
		super.setId(id);
	}

	public Concours getConcours() {
		return concours;
	}

	public void setConcours(Concours concours) {
		this.concours = concours;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public LocalDateTime getDatePassage() {
		return datePassage;
	}

	public void setDatePassage(LocalDateTime datePassage) {
		this.datePassage = datePassage;
	}

	public List<ResultatQuestionConcours> getListResultatQuestions() {
		return listResultatQuestions;
	}

	public void setListResultatQuestions(List<ResultatQuestionConcours> listResultatQuestions) {
		this.listResultatQuestions = listResultatQuestions;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
	
	
}
