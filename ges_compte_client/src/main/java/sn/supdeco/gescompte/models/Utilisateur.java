package sn.supdeco.gescompte.models;


import java.io.Serializable;

public class Utilisateur implements Serializable {
    private String id;
    private String nom;
    private String prenom;

    public Utilisateur() {
    }

    public Utilisateur(String id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
