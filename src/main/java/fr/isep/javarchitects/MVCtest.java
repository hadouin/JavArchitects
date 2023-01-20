package fr.isep.javarchitects;

import fr.isep.javarchitects.controllers.GameViewController;
import fr.isep.javarchitects.model.GameModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCtest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameModel gameModel = new GameModel();
        GameViewController gameViewController = new GameViewController();
        gameViewController.init(gameModel, stage);

        stage.setScene(new Scene(gameViewController.getRootComponent()));
        gameModel.initializePlayers("Hadouin", "Julie", "Romeo");
        stage.show();
    }
}
