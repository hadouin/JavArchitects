package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.controls.DeckControl;
import fr.isep.javarchitects.controls.WonderDisplayControl;
import fr.isep.javarchitects.core.command.GameAction;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerViewController {
    @FXML
    Label informationLabel;
    @FXML
    HBox buttonHBox;
    @FXML
    HBox generalHBox;
    @FXML
    HBox headerHBox;
    @FXML
    HBox warTokensHBox;
    @FXML
    HBox progressTokensHBox;
    @FXML
    VBox logVBox;

    DeckControl leftDeckDisplay = new DeckControl();
    DeckControl rightDeckDisplay = new DeckControl();
    WonderDisplayControl wonderDisplayControl = new WonderDisplayControl();

    private PlayerModel player;

    GameModel model; // DataModel

    @FXML
    public void initialize(){
        this.generalHBox.getChildren().addAll(leftDeckDisplay, wonderDisplayControl, rightDeckDisplay);
    }

    public void initModel(GameModel model){
        // ensure model is set once
        if (this.model != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        model.getGameActionList().addListener(new ListChangeListener<GameAction>() {
            @Override
            public void onChanged(Change<? extends GameAction> change) {
                buttonHBox.getChildren().clear();
                if (model.currentPlayerProperty().get() != player){
                    return;
                }
                for (GameAction gameAction: change.getList()) {
                    Button button = new Button(gameAction.name);
                    button.setOnAction(actionEvent -> {
                        gameAction.execute();
                    });
                    buttonHBox.getChildren().add(button);
                }
            }
        });
    }

    public void initPlayer(PlayerModel playerModel){
        if (this.player != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.player = playerModel;

        informationLabel.textProperty().bindBidirectional(player.nameProperty());
        wonderDisplayControl.wonderObjectPropertyProperty().bindBidirectional(player.wonderProperty());
        leftDeckDisplay.imageObjectProperty().bindBidirectional(player.selfDeckProperty().get().topDeckImageProperty());
        leftDeckDisplay.nbCardsProperty().bindBidirectional(player.selfDeckProperty().get().nbCardsProperty());
        rightDeckDisplay.imageObjectProperty().bindBidirectional(player.rightDeckProperty().get().topDeckImageProperty());
        rightDeckDisplay.nbCardsProperty().bindBidirectional(player.rightDeckProperty().get().nbCardsProperty());
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }
}
