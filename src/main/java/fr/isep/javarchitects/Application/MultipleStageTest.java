package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Fenetres.GameUI;
import fr.isep.javarchitects.GameController;
import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.model.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * An app to test the creation of multiple stage and the global implementation of the observer patter
 * Verifying the update on either button click
 */
public class MultipleStageTest extends Application {

    GameController gameController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.gameController = new GameController(new Game(1, List.of("Hadouin")));
        Button button = new Button("Ok depart");
        button.setOnAction(e -> {
            gameController.triggerOkDepart(e);
        });
        Button otherbutton = new Button("Ok depart");
        otherbutton.setOnAction(e -> {
            gameController.triggerOkDepart(e);
        });

        Pane root = new VBox(button);
        Pane otherRoot = new VBox(otherbutton);

        Scene scene = new Scene(root, 200, 100);
        Scene otherScene = new Scene(otherRoot, 200 , 100);

        GameUI firstStage = new GameUI(GameStateVisible.BASE_STATE);
        gameController.subscribe(firstStage);

        GameUI secondStage = new GameUI(GameStateVisible.BASE_STATE);
        gameController.subscribe(secondStage);

        firstStage.setTitle("First Stage");
        firstStage.setScene(scene);

        secondStage.setTitle("Second Stage");
        secondStage.setScene(otherScene);

        firstStage.show();
        secondStage.show();
    }
}
