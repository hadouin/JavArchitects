package fr.isep.javarchitects.controls;

import fr.isep.javarchitects.components.PointCounter;
import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.ProgressToken;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.utils.CardByTypeCounters;
import fr.isep.javarchitects.utils.Icons;
import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
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


    PointCounter pointCounter = new PointCounter(Icons.VP, 0);
    PointCounter battleCounter = new PointCounter(Icons.BATTLE_TOKEN, 0);

    PlayerModel model;

    public void initModel(PlayerModel model){
        // ensure model is set once
        if (this.model != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        model.getOwnedCardList().addListener((ListChangeListener<Card>) change -> populateFields());

        model.ownedProgressTokensListProperty().addListener(new ListChangeListener<ProgressToken>() {
            @Override
            public void onChanged(Change<? extends ProgressToken> c) {
                c.next();

                for (ProgressToken token : c.getAddedSubList()) {
                    DeckControl iconDisplay = new DeckControl();
                    iconDisplay.setImageObject(new Image(getClass().getResourceAsStream(token.imageResource)));
                    iconDisplay.setNbCards(model.getPlayerWarPoints());
                    iconDisplay.setFitWidth(40);
                    progressTokenVBox.getChildren().add(iconDisplay);
                }
            }
        });


        model.playerWarPointsProperty().addListener((obs, oldPoints, newPoints) -> {
            militaryHBox.getChildren().clear();
            DeckControl iconDisplay = new DeckControl();
            iconDisplay.setImageObject(Icons.SHIELD.image);
            iconDisplay.setNbCards(model.getPlayerWarPoints());
            iconDisplay.setFitWidth(40);
            militaryHBox.getChildren().add(iconDisplay);
        });

        pointCounter.counter.textProperty().bind(Bindings.convert(model.playerGloryPointsProperty()));
        model.playerGloryPointsProperty().addListener((obs, oldPoints, newPoints) -> {
            if (oldPoints.intValue() == 0){
                vpHBox.getChildren().add(0, pointCounter);
            }
        });
        battleCounter.counter.textProperty().bind(Bindings.convert(model.vpWonInBattleProperty()));
        model.vpWonInBattleProperty().addListener(((obs, oldNumber, newNumber) -> {
            if (oldNumber.intValue() == 0){
                vpHBox.getChildren().add(vpHBox.getChildren().size(), battleCounter);
            }
        }));

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
                    iconDisplay.setFitWidth(40);
                    materialHBox.getChildren().add(iconDisplay);
                }
                case ProgressCard -> {
                    DeckControl iconDisplay = new DeckControl();
                    iconDisplay.setImageObject(card.scienceCategory.icon.image);
                    iconDisplay.setNbCards(cardByTypeCounters.get(card));
                    iconDisplay.setFitWidth(40);
                    scienceHBox.getChildren().add(iconDisplay);
                }

            }

        }
    }

}
