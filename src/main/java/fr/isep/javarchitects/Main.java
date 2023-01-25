package fr.isep.javarchitects;

import fr.isep.javarchitects.components.SplashScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application to be launch by default, nothing yet still testing
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        SplashScreen splashScreen = new SplashScreen(()->{
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/views/MenuView.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(new Scene(root));
            stage.setTitle("Choose Players");
            stage.show();
        });
        splashScreen.show();
        splashScreen.startLoading();
    }
}



