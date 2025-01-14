/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author neal.yvard
 */
public class Coureurs {
    private int place;
    private String nom;
    private String prenom;
    private String temps;

    public Coureurs() {
    }

    public Coureurs(int place, String nom, String prenom, String temps) {
        this.place = place;
        this.nom = nom;
        this.prenom = prenom;
        this.temps = temps;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
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

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }
    
    
}
