package fr.isep.javarchitects.components;

import fr.isep.javarchitects.command.GameAction;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameChoiceComponent extends VBox {
    private final Label instructionsLabel = new Label();
    private final HBox buttonsHBox = new HBox();
    private GameModel gameModel;
    private PlayerModel currentPlayer;

    public GameChoiceComponent(){
        this.getChildren().addAll(instructionsLabel, buttonsHBox);
    }

    public void initGameModel(GameModel gameModel){
        // ensure model is set once
        if (this.gameModel != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.gameModel = gameModel;

        gameModel.getGameActionList().addListener((ListChangeListener<GameAction>) change -> {
            buttonsHBox.getChildren().clear();
            if (currentPlayer != null && gameModel.getCurrentPlayer() != currentPlayer){
                return;
            }
            instructionsLabel.setText("Actions for: " + gameModel.getCurrentPlayer().getName());

            for (GameAction gameAction: change.getList()) {
                Button button = new Button(gameAction.name);
                button.setOnAction(actionEvent -> {
                    gameModel.executeCommand(gameAction);
                });
                buttonsHBox.getChildren().add(button);
            }
        });
    }

    public void setCurrentPlayer(PlayerModel playerModel){
        this.currentPlayer = playerModel;
    }
}
