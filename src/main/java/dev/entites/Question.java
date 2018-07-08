package dev.entites;

import java.util.List;

public class Question extends BaseEntite {

    private String titre;

    private List<OptionQuestion> options;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<OptionQuestion> getOptions() {
        return options;
    }

    public void setOptions(List<OptionQuestion> options) {
        this.options = options;
    }
}
