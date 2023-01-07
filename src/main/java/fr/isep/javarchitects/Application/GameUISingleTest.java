package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Fenetres.GameUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameUISingleTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameUI game1 = new GameUI();
        game1.show();
    }
}
