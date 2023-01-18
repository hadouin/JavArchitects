package fr.isep.javarchitects.components;

import fr.isep.javarchitects.core.PlayerVisible;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerViewHBox extends HBox {
    private DeckDisplay leftDeckDisplay;
    private DeckDisplay rightDeckDisplay;
    private WonderDisplay wonderDisplay;
    private Inventory inventory;
    private PlayerVisible playerVisible;

    // private Inventory inventory;
    public PlayerViewHBox(PlayerVisible playerVisible){
        this.playerVisible = playerVisible;
        this.setPadding(new Insets(20.));
        this.setSpacing(50.);
        this.setAlignment(Pos.CENTER);

        this.wonderDisplay = new WonderDisplay(playerVisible.wonder.get());
        this.inventory = new Inventory();
        inventory.updateInventory(playerVisible);
        wonderDisplay.setWonder(playerVisible.wonder.get());
        VBox centerVBox = new VBox(wonderDisplay, inventory);

        leftDeckDisplay = new DeckDisplay(playerVisible.leftTopDeck.getJavaFXImage(), playerVisible.leftDeckTotal);
        rightDeckDisplay = new DeckDisplay(playerVisible.rightTopDeck.getJavaFXImage(), playerVisible.rightDeckTotal);
        this.getChildren().addAll(leftDeckDisplay, centerVBox, rightDeckDisplay);

    }

    private void update() {
        leftDeckDisplay.setImage(playerVisible.leftTopDeck.getJavaFXImage());
        leftDeckDisplay.setNbCards(playerVisible.leftDeckTotal);
        rightDeckDisplay.setImage(playerVisible.rightTopDeck.getJavaFXImage());
        rightDeckDisplay.setNbCards(playerVisible.rightDeckTotal);
        inventory.updateInventory(playerVisible);
    }

    public void setPlayer(PlayerVisible playerVisible) {
        this.playerVisible = playerVisible;
        update();
    }
}
