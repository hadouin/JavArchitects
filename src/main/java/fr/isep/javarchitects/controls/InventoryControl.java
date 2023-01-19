package fr.isep.javarchitects.controls;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.utils.CardByTypeCounters;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InventoryControl {
    @FXML
    HBox materialHBox;
    @FXML
    HBox militaryHBox;
    @FXML
    HBox scienceHBox;
    @FXML
    HBox vpHBox;
    @FXML
    VBox progressTokenVBox;

    PlayerModel model;

    public void initModel(PlayerModel model){
        // ensure model is set once
        if (this.model != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        model.getOwnedCardList().addListener(new ListChangeListener<Card>() {
            @Override
            public void onChanged(Change<? extends Card> change) {
                populateFields();
            }
        });

        populateFields();
    }

    private void populateFields() {
        materialHBox.getChildren().clear();
        scienceHBox.getChildren().clear();
        CardByTypeCounters cardByTypeCounters = new CardByTypeCounters(model.getOwnedCardList());
        for (Card card : Card.values()){
            if (cardByTypeCounters.get(card) == 0){
                continue;
            }
            switch (card.cardCategory){
                case MaterialCard -> {
                    DeckControl iconDisplay = new DeckControl();
                    iconDisplay.setImageObject(card.material.icon.image);
                    iconDisplay.setNbCards(cardByTypeCounters.get(card));
                    materialHBox.getChildren().add(iconDisplay);
                }
                case ProgressCard -> {
                    DeckControl iconDisplay = new DeckControl();
                    iconDisplay.setImageObject(card.scienceCategory.icon.image);
                    iconDisplay.setNbCards(cardByTypeCounters.get(card));
                    scienceHBox.getChildren().add(iconDisplay);
                }
            }
        }
    }

}
