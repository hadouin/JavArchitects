package fr.isep.javarchitects;

import fr.isep.javarchitects.controllers.PlayerViewController;
import fr.isep.javarchitects.core.DeckFactory;
import fr.isep.javarchitects.core.WonderFactory;
import fr.isep.javarchitects.core.command.DrawCard;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MVCtest extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        TabPane root = new TabPane();
        GameModel model = new GameModel();

        model.getPlayerList().addListener(new ListChangeListener<PlayerModel>() {
            @Override
            public void onChanged(Change<? extends PlayerModel> change) {
                change.next();
                for (PlayerModel player : change.getAddedSubList()) {

                    Tab tab = new Tab();
                    tab.setText(player.getName());

                    FXMLLoader playerViewLoader = new FXMLLoader(getClass().getResource("/views/PlayerView.fxml"));
                    try {
                        tab.setContent(playerViewLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    root.getTabs().add(tab);

                    PlayerViewController playerViewController = playerViewLoader.getController();
                    playerViewController.initModel(model);
                    playerViewController.initPlayer(player);
                }
            }
        });

        model.initializePlayers("Hadouin", "Julie");


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
