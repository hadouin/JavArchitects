package fr.isep.javarchitects;

import fr.isep.javarchitects.components.Inventory;
import fr.isep.javarchitects.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
        cards.add(Card.CardScienceMechanic);
        cards.add(Card.CardWar_centurion);
        cards.add(Card.CardWar_barbarian);
        cards.add(Card.CardScienceLaw);
        cards.add(Card.CardMaterialGold);
        cards.add(Card.CardMaterialGold);
        cards.add(Card.CardPolitic_emperor);

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
