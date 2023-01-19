package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.controls.DeckControl;
import fr.isep.javarchitects.controls.WonderDisplayControl;
import fr.isep.javarchitects.core.command.GameAction;
import fr.isep.javarchitects.model.GameModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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

        model.currentPlayerProperty().addListener((obs, oldPlayer, newPlayer) -> {
            if (oldPlayer != null){
                informationLabel.textProperty().unbindBidirectional(oldPlayer.nameProperty());
            }
            if (newPlayer == null) {
                informationLabel.setText("");
            } else {
                informationLabel.textProperty().bindBidirectional(newPlayer.nameProperty());
                wonderDisplayControl.wonderObjectPropertyProperty().bindBidirectional(newPlayer.wonderProperty());
                leftDeckDisplay.imageObjectProperty().bindBidirectional(newPlayer.selfDeckProperty().get().topDeckImageProperty());
                leftDeckDisplay.nbCardsProperty().bindBidirectional(newPlayer.selfDeckProperty().get().nbCardsProperty());
                rightDeckDisplay.imageObjectProperty().bindBidirectional(newPlayer.rightDeckProperty().get().topDeckImageProperty());
                rightDeckDisplay.nbCardsProperty().bindBidirectional(newPlayer.rightDeckProperty().get().nbCardsProperty());
            }
        });
        model.getGameActionList().addListener(new ListChangeListener<GameAction>() {
            @Override
            public void onChanged(Change<? extends GameAction> change) {
                buttonHBox.getChildren().clear();
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
}
