package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.io.*;
import java.util.ArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.xml.sax.*;
import modele.Coureurs;
import modele.Courses;
import modele.Gestionnaire;
import javafx.scene.control.cell.PropertyValueFactory;


public class Fen_ListeController implements Initializable {

    @FXML
    private ComboBox<String> cb_courses;
    
    @FXML
    private TableView<Coureurs> tableViewCoureurs;  // TableView pour afficher les objets Coureurs
    
    @FXML
    private TableColumn<Coureurs, String> col_place;   // Colonne pour afficher le nom des coureurs
    @FXML
    private TableColumn<Coureurs, String> col_nom; // Colonne pour afficher le temps des coureurs
    @FXML
    private TableColumn<Coureurs, String> col_prenom; // Colonne pour afficher le temps des coureurs
    @FXML
    private TableColumn<Coureurs, String> col_temps; // Colonne pour afficher le temps des coureurs

    // Déclarer listeDeCourses comme une variable d'instance pour y accéder dans toute la classe
    private ArrayList<Courses> listeDeCourses;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Création du parser SAX
            Class c = Class.forName("org.apache.xerces.parsers.SAXParser");
            XMLReader parser = (XMLReader) c.newInstance();
            Gestionnaire analyse = new Gestionnaire();
            parser.setContentHandler(analyse);
            parser.parse(".\\src\\assets\\resultatChallenge.xml");  // Le chemin vers votre XML

            // Récupérer la liste des courses
            listeDeCourses = analyse.retour(); // Initialiser la variable d'instance

            // Ajouter les noms des courses à la ComboBox
            for (Courses course : listeDeCourses) {
                cb_courses.getItems().add(course.getIntitule());
            }

        } catch (Exception e) {
            System.out.println("Erreur lors de l'analyse du fichier XML: " + e.getMessage());
            e.printStackTrace();
        }

        // Écouter les changements dans la sélection de la ComboBox
        cb_courses.setOnAction(event -> lanceTraitementSAX());
    }

    // La méthode lanceTraitementSAX qui prend la course sélectionnée comme paramètre
    public void lanceTraitementSAX() {
    // Récupérer le nom de la course sélectionnée dans le ComboBox
    String courseSelectionneeIntitule = cb_courses.getSelectionModel().getSelectedItem();
    System.out.println("Course séléctionée: " + courseSelectionneeIntitule);
    
    // Vérifier si une course est sélectionnée
    if (courseSelectionneeIntitule != null) {
        // Trouver la course correspondante dans la liste des courses
        Courses courseSelectionnee = null;
        for (Courses course : listeDeCourses) {
            if (course.getIntitule().equals(courseSelectionneeIntitule)) {
                courseSelectionnee = course;
                break;
            }
        }

        // Vérifier si la course existe dans la liste
        if (courseSelectionnee != null) {
            // Récupérer la liste des coureurs de la course sélectionnée
            ArrayList<Coureurs> listeCoureurs = courseSelectionnee.getLesCoureurs();

            // Convertir la liste en ObservableList pour l'afficher dans le TableView
            ObservableList<Coureurs> coureursObservableList = observableArrayList(listeCoureurs);

            // Remplir le TableView avec les coureurs
            
            col_place.setCellValueFactory(new PropertyValueFactory<>("place"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_temps.setCellValueFactory(new PropertyValueFactory<>("temps"));
            
            // Ajouter les données au TableView
            tableViewCoureurs.setItems(coureursObservableList);
        } else {
            // Gérer le cas où la course n'a pas été trouvée
            System.out.println("Course non trouvée !");
        }
    } else {
        // Gérer le cas où aucune course n'est sélectionnée
        System.out.println("Aucune course sélectionnée !");
    }
}
}
