package fr.isep.javarchitects;

import fr.isep.javarchitects.components.SplashScreen;
import fr.isep.javarchitects.controllers.GameController;
import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.views.GameUI;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

/**
 * Application to be launch by default, nothing yet still testing
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.show();
        splashScreen.startLoading();
    }

}



