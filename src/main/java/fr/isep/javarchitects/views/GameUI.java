package fr.isep.javarchitects.views;

import fr.isep.javarchitects.components.*;
import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.utils.Subscriber;
import fr.isep.javarchitects.model.WonderFactory;
import fr.isep.javarchitects.utils.Icons;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    private final Image CAT_IMAGE = new Image(getClass().getResourceAsStream("/images/tokens/token-cat.png"));
    private ImageView catImageView;


    @Override
    public void update(GameStateVisible gameStateVisible) {
        this.gameStateVisible = gameStateVisible;
        updateGame();
    }

    private void updateGame() {
        conflictTokensHBox.setConflictTokenList(gameStateVisible.conflictTokens);
        progressTokenView.setVisibleTokens(gameStateVisible.visibleProgressTokens);
        choiceDisplayHBox.setGameActionList(gameStateVisible.gameActionList);
        if (gameStateVisible.getCatOwner(gameStateVisible.players) != null){
            catImageView.setImage(null);
        } else {
            catImageView.setImage(CAT_IMAGE);
        }
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

        choiceDisplayHBox = new ChoiceDisplayHBox(null);
        AnchorPane.setLeftAnchor(choiceDisplayHBox, 100.);
        AnchorPane.setBottomAnchor(choiceDisplayHBox, 0.);
        rootPane.getChildren().add(choiceDisplayHBox);

        catImageView = new ImageView(CAT_IMAGE);
        catImageView.setFitWidth(catImageView.getImage().getWidth()/3);
        catImageView.setPreserveRatio(true);
        AnchorPane.setLeftAnchor(catImageView, 500.);
        rootPane.getChildren().add(catImageView);

        PlayerView playerView = new PlayerView(gameStateVisible.players.get(0));
        AnchorPane.setTopAnchor(playerView, 200.);
        AnchorPane.setLeftAnchor(playerView, 0.);
        AnchorPane.setRightAnchor(playerView, 0.);
        rootPane.getChildren().add(playerView);
    }

}
