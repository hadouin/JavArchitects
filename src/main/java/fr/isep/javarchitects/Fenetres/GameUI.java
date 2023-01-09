package fr.isep.javarchitects.Fenetres;

import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.Subscriber;
import fr.isep.javarchitects.TestState;
import fr.isep.javarchitects.components.ConflictTokensHBox;
import fr.isep.javarchitects.components.ProgressTokenPane;
import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.ProgressToken;
import fr.isep.javarchitects.model.ProgressTokens;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * GameUI is the main compent of ui view for the game.
 * It is a stage that will subscribe to the controller/publisher changes
 */
public class GameUI extends Stage implements Subscriber {
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1000;

    private GameStateVisible gameStateVisible;
    private Pane rootPane;
    private Scene mainScene;
    private ProgressTokenPane progressTokenView;
    private ConflictTokensHBox conflictTokensHBox;


    @Override
    public void update(GameStateVisible gameStateVisible) {
        this.gameStateVisible = gameStateVisible;
        updateGame();
    }

    private void updateGame() {
        conflictTokensHBox.setConflictTokenList(gameStateVisible.conflictTokens);
        progressTokenView.setVisibleTokens(gameStateVisible.visibleProgressTokens);
    }

    public GameUI(GameStateVisible gameStateVisible){
        this.gameStateVisible = gameStateVisible;
        this.rootPane = new AnchorPane();
        this.mainScene = new Scene(rootPane, WIDTH, HEIGHT);
        this.setTitle("JavArchitects");
        this.setScene(mainScene);
        setupGame();
    }

    private void setupGame(){
        progressTokenView = new ProgressTokenPane(gameStateVisible.visibleProgressTokens);
        AnchorPane.setRightAnchor(progressTokenView, 2.);
        rootPane.getChildren().add(progressTokenView);

        conflictTokensHBox = new ConflictTokensHBox(gameStateVisible.conflictTokens);
        AnchorPane.setLeftAnchor(conflictTokensHBox, 2.);
        rootPane.getChildren().add(conflictTokensHBox);
    }

}
