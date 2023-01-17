package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.PlayerVisible;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PlayerView extends HBox {
    private DeckDisplay leftDeckDisplay;
    private DeckDisplay rightDeckDisplay;
    private WonderDisplay wonderDisplay;
    private Inventory inventory;

    // private Inventory inventory;
    public PlayerView(PlayerVisible playerVisible){
        this.setPadding(new Insets(20.));
        this.setSpacing(50.);
        this.setAlignment(Pos.CENTER);

        this.wonderDisplay = new WonderDisplay(playerVisible.wonder);
        this.inventory = new Inventory();
        inventory.updateInventory(playerVisible);
        VBox centerVBox = new VBox(wonderDisplay, inventory);
        {
            Image imageLeft = new Image(getClass().getResourceAsStream(playerVisible.leftTopDeck.getFront().getImageResource()));
            leftDeckDisplay = new DeckDisplay(imageLeft, playerVisible.leftDeckTotal);
        }
        {
            Image imageRight = new Image(getClass().getResourceAsStream(playerVisible.rightTopDeck.getFront().getImageResource()));
            rightDeckDisplay = new DeckDisplay(imageRight, playerVisible.rightDeckTotal);
        }
        this.getChildren().addAll(leftDeckDisplay, centerVBox, rightDeckDisplay);

    }
}
