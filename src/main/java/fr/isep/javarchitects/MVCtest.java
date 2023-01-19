package fr.isep.javarchitects;

import fr.isep.javarchitects.controllers.PlayerViewController;
import fr.isep.javarchitects.core.DeckFactory;
import fr.isep.javarchitects.core.WonderFactory;
import fr.isep.javarchitects.core.command.DrawCard;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MVCtest extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        TabPane root = new TabPane();

        Tab tab = new Tab();
        FXMLLoader playerViewLoader = new FXMLLoader(getClass().getResource("/views/PlayerView.fxml"));
        tab.setContent(playerViewLoader.load());
        PlayerViewController playerViewController = playerViewLoader.getController();

        tab.setText("first Player");
        root.getTabs().add(tab);

        GameModel model = new GameModel();
        PlayerModel hadouin = new PlayerModel();
        playerViewController.initModel(model);
        hadouin.setName("Hadouin");
        hadouin.setWonder(WonderFactory.Alexandria.createWonder());
        hadouin.setSelfDeck(DeckFactory.Alexandria.createDeck());
        hadouin.setRightDeck(DeckFactory.Babylon.createDeck());
        model.setPlayers(hadouin);
        model.setCurrentPlayer(hadouin);

        // game action
        DrawCard currentPlayerDrawLeft = new DrawCard(model, "Draw Left", hadouin, hadouin.getSelfDeck().getCards());
//        DrawCard currentPlayerDrawCenter = new DrawCard(this,"Draw Center", hadouin, centerDeck.getCards());
        DrawCard currentPlayerDrawRight = new DrawCard(model,"Draw Right", hadouin, hadouin.getRightDeck().getCards());
        model.setGameActionList(currentPlayerDrawLeft, currentPlayerDrawRight);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        hadouin.setName("Hadouin LEROY");
    }
}
