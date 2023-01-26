package fr.isep.javarchitects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fr/isep/javarchitects/views/MenuView.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Choose Players");
        stage.show();
    }
}
