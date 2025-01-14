package modele;

import java.util.ArrayList;

/**
 *
 * @author neal.yvard
 */
public class Courses {
    private String intitule;
    private int distance;
    private String dateCourse;
    private String lieu;
    private boolean challenge;
    private ArrayList<Coureurs> LesCoureurs;

    public Courses() {
         LesCoureurs = new ArrayList<>(); // Initialisation de la liste des coureurs
    }

    public Courses(String intitule, int distance, String dateCourse, String lieu, boolean challenge, ArrayList<Coureurs> LesCoureurs) {
        this.intitule = intitule;
        this.distance = distance;
        this.dateCourse = dateCourse;
        this.lieu = lieu;
        this.challenge = challenge;
        this.LesCoureurs = LesCoureurs;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(String dateCourse) {
        this.dateCourse = dateCourse;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public boolean isChallenge() {
        return challenge;
    }

    public void setChallenge(boolean challenge) {
        this.challenge = challenge;
    }

    public ArrayList<Coureurs> getLesCoureurs() {
        return LesCoureurs;
    }

    public void setLesCoureurs(ArrayList<Coureurs> LesCoureurs) {
        this.LesCoureurs = LesCoureurs;
    }

    
}
