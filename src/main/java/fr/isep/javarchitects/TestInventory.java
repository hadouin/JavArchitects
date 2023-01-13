package fr.isep.javarchitects;

import fr.isep.javarchitects.components.Inventory;
import fr.isep.javarchitects.components.pointCounter;
import fr.isep.javarchitects.model.*;
import fr.isep.javarchitects.utils.Icons;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestInventory extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane AP = new AnchorPane();
        VBox I = new Inventory();
        AP.getChildren().add(I);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.CardScienceMechanic, CardBack.CentralDeck));

        // cards.add(new Card(CardType.CardWar_barbarian, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardWar_centurion, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardWar_barbarian, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardScienceLaw, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardMaterialGold, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardMaterialGold, CardBack.CentralDeck));
        cards.add(new Card(CardType.CardPolitic_cat, CardBack.CentralDeck));
        PlayerVisible playerTest = new PlayerVisible("Romeo", cards);
        ((Inventory) I).updateInventory(playerTest);

        Scene scene = new Scene(AP, 700, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
