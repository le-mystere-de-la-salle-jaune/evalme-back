package dev.entites;

public class OptionQuestion extends BaseEntite {

    private String libelle;

    private Boolean isOK;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getOK() {
        return isOK;
    }

    public void setOK(Boolean OK) {
        isOK = OK;
    }
}
