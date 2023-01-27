package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.components.GameChoiceComponent;
import fr.isep.javarchitects.components.GameHeaderComponent;
import fr.isep.javarchitects.components.GameLogComponent;
import fr.isep.javarchitects.components.SinglePlayerDisplay;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Scale;

public class PlayerGlobalViewController {

    private static final int COLUMNS = 3;
    private static final Scale scale = new Scale(0.33, 0.33);
    private final BorderPane root = new BorderPane();
    private final GameHeaderComponent gameHeaderComponent = new GameHeaderComponent();
    private final GameLogComponent gameLogComponent = new GameLogComponent();
    private final GameChoiceComponent gameChoiceComponent = new GameChoiceComponent();
    
    private final GridPane playerGrid = new GridPane();
    private GameModel gameModel;

    public PlayerGlobalViewController(){
        this.root.setTop(gameHeaderComponent);
        this.root.setRight(gameLogComponent);
        this.root.setCenter(playerGrid);
        this.root.setBottom(gameChoiceComponent);
    }

    public void initGameModel(GameModel gameModel){
        this.gameModel = gameModel;

        gameHeaderComponent.initGameModel(gameModel);
        gameLogComponent.setItems(gameModel.gameActionHistoryProperty().get().historyStack());
        gameChoiceComponent.initGameModel(gameModel);
    }
    
    public void addPlayer(PlayerModel playerModel){
        //add content
        int ordinal = gameModel.getPlayerList().indexOf(playerModel);
        int x = ordinal % COLUMNS;
        int y = ordinal / COLUMNS;

        SinglePlayerDisplay singlePlayerDisplay = new SinglePlayerDisplay();
        singlePlayerDisplay.initPlayer(playerModel);


        this.playerGrid.add(singlePlayerDisplay, x, y);
    }

    public Node getRootComponent() {
        return this.root;
    }
}

