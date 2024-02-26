package models;

public class InformationEducatif {
    private int idInformation;
    private String titre,contenu,auteur;



    public int idInformation() {
        return idInformation;
    }

    public void setIdInformation(int idInformation) {
        this.idInformation = idInformation;
    }

    public String titre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String contenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String auteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public InformationEducatif(int idInformation, String titre, String contenu, String auteur) {
        this.idInformation = idInformation;
        this.titre = titre;
        this.contenu = contenu;
        this.auteur = auteur;
    }
    public InformationEducatif( String titre, String contenu, String auteur) {

        this.titre = titre;
        this.contenu = contenu;
        this.auteur = auteur;
    }
    public InformationEducatif() {
    }



}
