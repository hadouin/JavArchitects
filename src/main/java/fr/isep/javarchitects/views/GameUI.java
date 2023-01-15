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
    //private MysteryDeckVBox mysteryDeckVBox;
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

    public String getWindowTitle(){
        String ret = "JavArchitects ";
        int nbPlayers = this.gameStateVisible.players.size();
        ret+= nbPlayers+" joueurs";
        return ret;
    }

    public GameUI(GameStateVisible gameStateVisible){
        this.gameStateVisible = gameStateVisible;
        this.rootPane = new AnchorPane();
        this.mainScene = new Scene(rootPane, WIDTH, HEIGHT);
        this.setTitle(getWindowTitle());
        this.setScene(mainScene);
        Stage stage = (Stage) this.mainScene.getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icons/appIcon.png")));
        setupGame();
    }

    private void setupGame(){
        progressTokenView = new ProgressTokenPane(gameStateVisible.visibleProgressTokens);
        AnchorPane.setRightAnchor(progressTokenView, 2.);
        rootPane.getChildren().add(progressTokenView);

        conflictTokensHBox = new ConflictTokensHBox(gameStateVisible.conflictTokens);
        AnchorPane.setLeftAnchor(conflictTokensHBox, 2.);
        rootPane.getChildren().add(conflictTokensHBox);

        //mysteryDeckVBox = new MysteryDeckVBox(gameStateVisible.mysteryDeck);
        //AnchorPane.setLeftAnchor(mysteryDeckVBox, 300.);
        //rootPane.getChildren().add(mysteryDeckVBox);

        WonderDisplay wonderDisplay = new WonderDisplay(WonderFactory.Alexandria.createWonder());
        AnchorPane.setLeftAnchor(wonderDisplay, 200.);
        AnchorPane.setTopAnchor(wonderDisplay, 200.);
        rootPane.getChildren().add(wonderDisplay);

        choiceDisplayHBox = new ChoiceDisplayHBox(null);
        AnchorPane.setLeftAnchor(choiceDisplayHBox, 100.);
        AnchorPane.setBottomAnchor(choiceDisplayHBox, 0.);
        rootPane.getChildren().add(choiceDisplayHBox);

        catImageView = new ImageView(CAT_IMAGE);
        catImageView.setFitWidth(catImageView.getImage().getWidth()/3);
        catImageView.setPreserveRatio(true);
        AnchorPane.setLeftAnchor(catImageView, 500.);
        rootPane.getChildren().add(catImageView);

        ImageView iconTestView = new ImageView(Icons.STONE.image);
        AnchorPane.setTopAnchor(iconTestView, 100.);
        rootPane.getChildren().add(iconTestView);

        WonderDisplay alexandrieDisplay = new WonderDisplay(WonderFactory.Gizeh.createWonder());
        AnchorPane.setLeftAnchor(alexandrieDisplay, 200.);
        AnchorPane.setTopAnchor(alexandrieDisplay, 200.);
        rootPane.getChildren().add(alexandrieDisplay);
        { Image image = new Image(getClass().getResourceAsStream("/images/cards/card-progress-law.png"));
        DeckDisplay deckDisplay = new DeckDisplay(image, 2);
        deckDisplay.setPrefWidth(200);
        deckDisplay.setPrefHeight(300);
        rootPane.getChildren().add(deckDisplay);
        }
    }

}
