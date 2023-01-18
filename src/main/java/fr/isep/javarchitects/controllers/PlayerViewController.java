package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.controls.WonderDisplayControl;
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

    WonderDisplayControl wonderDisplayControl = new WonderDisplayControl();

    GameModel model; // DataModel

    @FXML
    public void initialize(){
        this.mainPane.getChildren().add(wonderDisplayControl);
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
            }
        });

    }
}
