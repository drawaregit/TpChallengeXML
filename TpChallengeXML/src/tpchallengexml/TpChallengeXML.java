package tpchallengexml;

import java.io.*;
import java.util.ArrayList;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import modele.Coureurs;
import modele.Gestionnaire;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TpChallengeXML extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Chargement de la fenêtre FXML
        Parent root = FXMLLoader.load(getClass().getResource("/vues/Fen_Liste.fxml"));
        primaryStage.setTitle("Gestion des Courses");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Démarrer le traitement SAX après l'affichage de la fenêtre
        lancerTraitementSAX();
    }

    public static void main(String[] args) {
        launch(args); // Lance l'application JavaFX
    }

    private void lancerTraitementSAX() {
        
    }
}
