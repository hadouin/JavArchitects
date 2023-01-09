package fr.isep.javarchitects.Application;

import fr.isep.javarchitects.Views.GameUI;
import fr.isep.javarchitects.GameController;
import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.components.SplashScreen;
import fr.isep.javarchitects.model.Game;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class GameUISingleTest extends Application {
    GameController gameController = new GameController(new Game(1, List.of("Hadouin")));
    @Override
    public void start(Stage stage) throws Exception {
        GameUI game1 = new GameUI(GameStateVisible.BASE_STATE);
        SplashScreen splashScreen = new SplashScreen(() -> {
            game1.show();
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(2000));
            pauseTransition.setOnFinished(e -> {
                gameController.sendFirstTestState();
            });
        });
        splashScreen.show();
        splashScreen.startLoading();
    }
}
