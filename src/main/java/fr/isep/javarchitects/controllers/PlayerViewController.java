package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.controls.DeckControl;
import fr.isep.javarchitects.controls.InventoryControl;
import fr.isep.javarchitects.controls.WonderDisplayControl;
import fr.isep.javarchitects.model.command.GameAction;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

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
    DeckControl centerDeckDisplay = new DeckControl();
    WonderDisplayControl wonderDisplayControl = new WonderDisplayControl();

    private PlayerModel player;

    GameModel model; // DataModel

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

        VBox wonderVBox = new VBox();
        wonderVBox.getChildren().add(wonderDisplayControl);
        FXMLLoader inventoryLoader = new FXMLLoader(getClass().getResource("/views/InventoryControl.fxml"));
        Parent parent = null;
        try {
            parent = inventoryLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InventoryControl inventoryControl = inventoryLoader.getController();
        inventoryControl.initModel(player);
        wonderVBox.getChildren().add(parent);
        this.generalHBox.getChildren().addAll(leftDeckDisplay, wonderVBox, rightDeckDisplay);

        informationLabel.textProperty().bind(player.nameProperty());
        wonderDisplayControl.wonderObjectPropertyProperty().bind(player.wonderProperty());
        leftDeckDisplay.imageObjectProperty().bind(player.selfDeckProperty().get().topDeckImageProperty());
        leftDeckDisplay.nbCardsProperty().bind(player.selfDeckProperty().get().nbCardsProperty());
        rightDeckDisplay.imageObjectProperty().bind(player.rightDeckProperty().get().topDeckImageProperty());
        rightDeckDisplay.nbCardsProperty().bind(player.rightDeckProperty().get().nbCardsProperty());

        centerDeckDisplay.imageObjectProperty().setValue(model.centerDeckProperty().get().getCardBack().image);
        centerDeckDisplay.nbCardsProperty().bind(model.centerDeckProperty().get().nbCardsProperty());
        centerDeckDisplay.setFitWidth(50);
        this.headerHBox.getChildren().set(1, centerDeckDisplay);
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }
}
