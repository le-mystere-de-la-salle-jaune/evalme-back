package dev.entites;

import java.util.List;

public class Concours extends BaseEntite {

    private String titre;

    private List<Stagiaire> participants;

    private List<Quizz> quizzes;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Stagiaire> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Stagiaire> participants) {
        this.participants = participants;
    }

    public List<Quizz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quizz> quizzes) {
        this.quizzes = quizzes;
    }
}
