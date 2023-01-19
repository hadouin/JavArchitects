package fr.isep.javarchitects.controls;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
                change.next();
                for (Card card : change.getAddedSubList()) {
                    switch (card.cardCategory) {
                        case MaterialCard -> {
                            ImageView imageView = new ImageView(card.getMaterial().icon.image);
                            imageView.setPreserveRatio(true);
                            imageView.setFitWidth(40);
                            materialHBox.getChildren().add(imageView);
                        }
                        case ProgressCard -> {
                            ImageView imageView = new ImageView(card.getScienceCategory().icon.image);
                            imageView.setPreserveRatio(true);
                            imageView.setFitWidth(40);
                            scienceHBox.getChildren().add(imageView);
                        }
                    }
                }
            }
        });

        for (Card card : model.getOwnedCardList()) {
            switch (card.cardCategory) {
                case MaterialCard -> materialHBox.getChildren().add(new ImageView(card.getMaterial().icon.image));
                case ProgressCard -> scienceHBox.getChildren().add(new ImageView(card.getScienceCategory().icon.image));
            }
        }

    }

}
