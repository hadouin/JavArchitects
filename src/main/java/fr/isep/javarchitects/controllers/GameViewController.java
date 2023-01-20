package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameViewController {

    GameModel model;
    TabPane root = new TabPane();
    private Stage stage;

    public void init(GameModel model, Stage stage) {
        this.model = model;
        this.stage = stage;

        root.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

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

        model.currentPlayerProperty().addListener((obs, oldPlayer, newPlayer) -> {
            root.getSelectionModel().select(model.getPlayerList().indexOf(newPlayer));
        });

    }

    public Parent getRootComponent(){
        return root;
    }

}
