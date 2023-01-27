package fr.isep.javarchitects.components;

import fr.isep.javarchitects.controls.InventoryControl;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SinglePlayerDisplay extends HBox {

    private final DeckControl leftDeckDisplay = new DeckControl();
    private final DeckControl rightDeckDisplay = new DeckControl();
    private final WonderDisplayControl wonderDisplayControl = new WonderDisplayControl();
    private PlayerModel player;


    public void initPlayer(PlayerModel playerModel) {
        if (this.player != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.player = playerModel;

        // init inventory
        FXMLLoader inventoryLoader = new FXMLLoader(getClass().getResource("/controls/InventoryControl.fxml"));
        Parent parent = null;
        try {
            parent = inventoryLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InventoryControl inventoryControl = inventoryLoader.getController();
        inventoryControl.initModel(player);

        // add center VBOX
        VBox wonderVBox = new VBox();
        wonderVBox.getChildren().addAll(wonderDisplayControl, parent);

        //add all to hbox
        this.getChildren().addAll(leftDeckDisplay, wonderVBox, rightDeckDisplay);

        //bind params
        wonderDisplayControl.wonderObjectPropertyProperty().bind(player.wonderProperty());
        leftDeckDisplay.imageObjectProperty().bind(player.selfDeckProperty().get().topDeckImageProperty());
        leftDeckDisplay.nbCardsProperty().bind(player.selfDeckProperty().get().nbCardsProperty());
        rightDeckDisplay.imageObjectProperty().bind(player.rightDeckProperty().get().topDeckImageProperty());
        rightDeckDisplay.nbCardsProperty().bind(player.rightDeckProperty().get().nbCardsProperty());
    }
}
