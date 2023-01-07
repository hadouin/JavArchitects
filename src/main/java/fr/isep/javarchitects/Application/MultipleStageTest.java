package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Fenetres.GameUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStageTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Button("OK"), 100, 100);
        Scene otherScene = new Scene(new Button("Depart"), 200 , 100);
        GameUI firstStage = new GameUI();
        GameUI secondStage = new GameUI();
        firstStage.setTitle("First Stage");
        firstStage.setScene(scene);
        secondStage.setTitle("Second Stage");
        secondStage.setScene(otherScene);
        firstStage.show();
        secondStage.show();
    }
}
