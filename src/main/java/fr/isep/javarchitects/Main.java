package fr.isep.javarchitects;

import fr.isep.javarchitects.controllers.GameController;
import fr.isep.javarchitects.utils.IVoidComplete;
import fr.isep.javarchitects.views.GameUI;
import fr.isep.javarchitects.components.SplashScreen;
import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.views.MenuView;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Application to be launch by default, nothing yet still testing
 */
public class Main extends Application {
    private GameController gameController;
    MenuView mView;
    ArrayList<String> playerNames;
    @Override

    public void start(Stage stage) throws Exception {
        SplashScreen splashScreen = new SplashScreen(() -> {
            this.mView = new MenuView( () ->{
                playerNames = this.mView.getMenuControllerInstance().getPlayerNames();
                this.gameController = new GameController(new Game(playerNames.size(), playerNames));
                GameUI firstGameWindow = new GameUI(GameStateVisible.BASE_STATE);
                gameController.subscribe(firstGameWindow);
                firstGameWindow.show();
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(2000));
                pauseTransition.setOnFinished(e -> {
                gameController.sendFirstTestState();
                });
                pauseTransition.play();
            });
        });
        splashScreen.show();
        splashScreen.startLoading();
    }

    public void startPlayerSelection() throws IOException {
        //MenuView mView = new MenuView(e -> {             this.startGame();         });
        MenuView mView = new MenuView( () ->{ this.startGame();} );
    }

    public IVoidComplete startGame(){
        this.gameController = new GameController(new Game(1, List.of("Hadouin")));
        GameUI firstGameWindow = new GameUI(GameStateVisible.BASE_STATE);
        gameController.subscribe(firstGameWindow);
        firstGameWindow.show();
        gameController.sendFirstTestState();
        return (IVoidComplete)null;
    }


    public void startOld(Stage stage) throws Exception {
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



