package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            new FenetrePrincipale(primaryStage);
            // primaryStage = fp.getMainStage();
            // primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {

        launch(args);
    }
}
