package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Fenetres.GameUI;
import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.components.SplashScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameUISingleTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameUI game1 = new GameUI(GameStateVisible.BASE_STATE);
        SplashScreen splashScreen = new SplashScreen(game1::show);
        splashScreen.show();
        splashScreen.startLoading();
    }
}
