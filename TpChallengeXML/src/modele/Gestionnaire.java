package modele;

import modele.Coureurs;
import modele.Courses;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.ArrayList;

public class Gestionnaire extends DefaultHandler {
    private ArrayList<Courses> lesCourses;  // Liste des courses
    private Courses maCourse;               // Objet course actuel
    private Coureurs monCoureur;            // Objet coureur actuel
    private String baliseCourante;          // Nom de la balise actuellement traitée

    @Override
public void startDocument() throws SAXException {
    // Initialisation des listes
    lesCourses = new ArrayList<>();
}


    @Override
    public void endDocument() throws SAXException {
        // Rien à faire ici pour l'instant
    }

    @Override
public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    if (qName.equals("course")) {
        // Création d'une nouvelle course
        maCourse = new Courses();
    } else if (qName.equals("coureur")) {
        // Création d'un nouveau coureur
        monCoureur = new Coureurs();
    }
    // Sauvegarde de la balise courante pour traitement dans characters()
    baliseCourante = qName;
}



    @Override
public void endElement(String uri, String localName, String qName) throws SAXException {
    // Vérifier que maCourse et monCoureur ne sont pas null avant de les utiliser
    if (qName.equals("coureur")) {
        if (maCourse != null && monCoureur != null) {
            maCourse.getLesCoureurs().add(monCoureur);  // Ajout du coureur à la liste des coureurs de la course
        } else {
            System.err.println("Erreur: maCourse ou monCoureur est null dans endElement!");
        }
    }
    if (qName.equals("course")) {
        if (maCourse != null) {
            lesCourses.add(maCourse);  // Ajout de la course à la liste des courses
        } else {
            System.err.println("Erreur: maCourse est null dans endElement!");
        }
    }
}



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Conversion du contenu textuel de la balise en String
        String donnees = new String(ch, start, length);
        if (!Character.isISOControl(ch[start]) && donnees.trim().length() > 0) {
            // Traitement en fonction de la balise courante
            if (baliseCourante.equals("intitule")) {
                maCourse.setIntitule(donnees);
            } else if (baliseCourante.equals("distance")) {
                maCourse.setDistance(Integer.parseInt(donnees));
            } else if (baliseCourante.equals("datecourse")) {
                maCourse.setDateCourse(donnees);
            } else if (baliseCourante.equals("lieu")) {
                maCourse.setLieu(donnees);
            } else if (baliseCourante.equals("challenge")) {
                maCourse.setChallenge(donnees.equals("Oui"));
            } else if (baliseCourante.equals("place")) {
                monCoureur.setPlace(Integer.parseInt(donnees));
            } else if (baliseCourante.equals("nom")) {
                monCoureur.setNom(donnees);
            } else if (baliseCourante.equals("prenom")) {
                monCoureur.setPrenom(donnees);
            } else if (baliseCourante.equals("temps")) {
                monCoureur.setTemps(donnees);
            }
        }
    }

    // Méthode pour récupérer la liste des courses
    public ArrayList<Courses> retour() {
        return lesCourses;
    }
}
