package models;

public class Allergie {
    private int id_al;
    private String nom, description;

    public Allergie() {
    }

    public Allergie(int id_al ,String nom, String description) {
        this.id_al = id_al;
        this.nom = nom;
        this.description = description;
    }
    public Allergie(String nom, String description) {

        this.nom = nom;
        this.description = description;
    }
    public  int getid_al() {
        return id_al;
    }

    public void setId_al(int id_al) {
        this.id_al = id_al;
    }

    public String getnom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Allergie{" +
                "id_al=" + id_al +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
