package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Views.GameUI;
import fr.isep.javarchitects.GameController;
import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.components.SplashScreen;
import fr.isep.javarchitects.model.Game;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.*;
import javafx.util.Duration;

import java.util.List;

/**
 * Application to be launch by default, nothing yet still testing
 */
public class Main extends Application {
    private GameController gameController;
    @Override
    public void start(Stage stage) throws Exception {
        this.gameController = new GameController(new Game(1, List.of("Hadouin")));
        GameUI firstGameWindow = new GameUI(GameStateVisible.BASE_STATE);
        gameController.subscribe(firstGameWindow);
        SplashScreen splashScreen = new SplashScreen(() -> {
            firstGameWindow.show();
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(2000));
            pauseTransition.setOnFinished(e -> {
                gameController.sendFirstTestState();
            });
            pauseTransition.play();
        });
        splashScreen.show();
        splashScreen.startLoading();
    }
}



