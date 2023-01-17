package fr.isep.javarchitects;

import fr.isep.javarchitects.components.Inventory;
import fr.isep.javarchitects.components.pointCounter;
import fr.isep.javarchitects.model.*;
import fr.isep.javarchitects.utils.Icons;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestInventory extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane AP = new AnchorPane();
        Inventory inventory = new Inventory();
        AP.getChildren().add(inventory);
        List<Card> cards = new ArrayList<>();
        List<ProgressToken> progressTokens = new ArrayList<>();
        cards.add(new Card(CardType.CardScienceMechanic, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardWar_centurion, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardWar_barbarian, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardScienceLaw, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardMaterialGold, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardMaterialGold, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardPolitic_emperor, CardBack.CentralDeck));

        progressTokens.add(ProgressToken.Politic);
        progressTokens.add(ProgressToken.Decoration);

        PlayerVisible playerTest = new PlayerVisible.Builder()
                .setName("Romeo")
                .setCards(cards)
                .setProgressTokens(progressTokens)
                .build();
        inventory.updateInventory(playerTest);

        Scene scene = new Scene(AP, 700, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
