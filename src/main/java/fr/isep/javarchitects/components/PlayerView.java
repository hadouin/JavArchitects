package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.PlayerVisible;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PlayerView extends HBox {
    private DeckDisplay leftDeckDisplay;
    private DeckDisplay rightDeckDisplay;
    private WonderDisplay wonderDisplay;

    // private Inventory inventory;
    PlayerView(PlayerVisible playerVisible){
        this.wonderDisplay = new WonderDisplay(playerVisible.wonder);
        {
            Image imageLeft = new Image(playerVisible.leftTopDeck.getFront().getImageResource());
            this.leftDeckDisplay = new DeckDisplay(imageLeft, playerVisible.leftDeckTotal);
        }
        {
            Image imageRight = new Image(playerVisible.rightTopDeck.getFront().getImageResource());
            this.rightDeckDisplay = new DeckDisplay(imageRight, playerVisible.rightDeckTotal);
        }
        this.setSpacing(50);
        this.getChildren().addAll(leftDeckDisplay, wonderDisplay, rightDeckDisplay);

    }
}
