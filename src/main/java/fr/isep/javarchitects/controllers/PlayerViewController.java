package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.model.GameModel;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PlayerViewController {
    @FXML
    Label informationLabel;
    @FXML
    ButtonBar buttonBar;
    @FXML
    Pane mainPane;
    @FXML
    HBox headerHBox;
    @FXML
    HBox warTokensHBox;
    @FXML
    HBox progressTokensHBox;
    @FXML
    VBox logVBox;

    GameModel model; // DataModel

    public void initModel(GameModel model){
        // ensure model is set once
        if (this.model != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        informationLabel.setText(model.getCurrentPlayer().getName());

        model.currentPlayerProperty().addListener((obs, oldPlayer, newPlayer) -> {
            if (oldPlayer != null){
                informationLabel.textProperty().bindBidirectional(oldPlayer.nameProperty());
            }
        });
    }
}
