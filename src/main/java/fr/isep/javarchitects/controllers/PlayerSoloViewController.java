package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.components.GameChoiceComponent;
import fr.isep.javarchitects.components.GameHeaderComponent;
import fr.isep.javarchitects.components.GameLogComponent;
import fr.isep.javarchitects.components.SinglePlayerDisplay;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class PlayerSoloViewController {
    private final BorderPane root = new BorderPane();
    private final GameHeaderComponent gameHeaderComponent = new GameHeaderComponent();
    private final GameLogComponent gameLogComponent = new GameLogComponent();
    private final SinglePlayerDisplay singlePlayerDisplay = new SinglePlayerDisplay();
    private final GameChoiceComponent gameChoiceComponent = new GameChoiceComponent();

    private GameModel gameModel;
    private PlayerModel playerModel;


    PlayerSoloViewController(){
        this.root.setTop(gameHeaderComponent);
        this.root.setRight(gameLogComponent);
        this.root.setCenter(singlePlayerDisplay);
        this.root.setBottom(gameChoiceComponent);
    }

    public void init(GameModel gameModel, PlayerModel playerModel){
        this.gameModel = gameModel;
        this.playerModel = playerModel;

        gameHeaderComponent.initGameModel(gameModel);
        gameLogComponent.setItems(gameModel.gameActionHistoryProperty().get().historyStack());
        singlePlayerDisplay.initPlayer(playerModel);
        gameChoiceComponent.initGameModel(gameModel);
        gameChoiceComponent.setRenderedPlayer(playerModel);
    }

    public Parent getRootComponent(){
        return this.root;
    }
}
