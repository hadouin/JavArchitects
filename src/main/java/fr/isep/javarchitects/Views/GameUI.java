package fr.isep.javarchitects.Views;

import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.Subscriber;
import fr.isep.javarchitects.components.ChoiceDisplayHBox;
import fr.isep.javarchitects.components.ConflictTokensHBox;
import fr.isep.javarchitects.components.ProgressTokenPane;
import fr.isep.javarchitects.components.WonderDisplay;
import fr.isep.javarchitects.model.Wonder;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * GameUI is the main component of ui view for the game.
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
    private ChoiceDisplayHBox choiceDisplayHBox;
    private ImageView centerDeck;


    @Override
    public void update(GameStateVisible gameStateVisible) {
        this.gameStateVisible = gameStateVisible;
        updateGame();
    }

    private void updateGame() {
        conflictTokensHBox.setConflictTokenList(gameStateVisible.conflictTokens);
        progressTokenView.setVisibleTokens(gameStateVisible.visibleProgressTokens);
        choiceDisplayHBox.setGameActionList(gameStateVisible.gameActionList);
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

        WonderDisplay wonderDisplay = new WonderDisplay(Wonder.Alexandrie);
        AnchorPane.setLeftAnchor(wonderDisplay, 200.);
        AnchorPane.setTopAnchor(wonderDisplay, 200.);
        rootPane.getChildren().add(wonderDisplay);

        choiceDisplayHBox = new ChoiceDisplayHBox(null);
        AnchorPane.setLeftAnchor(choiceDisplayHBox, 100.);
        AnchorPane.setBottomAnchor(choiceDisplayHBox, 0.);
        rootPane.getChildren().add(choiceDisplayHBox);
    }

}
