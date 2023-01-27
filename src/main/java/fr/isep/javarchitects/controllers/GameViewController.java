package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class GameViewController {

    GameModel model;
    TabPane root = new TabPane();
    private Stage stage;
    PlayerGlobalViewController playerGlobalViewController = new PlayerGlobalViewController();
    Tab globalTab = new Tab();
    private static final int COLUMNS = 3;

    public void init(GameModel model, Stage stage) {
        this.model = model;
        this.stage = stage;

        root.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        root.setMaxWidth(820);
        root.setMaxHeight(600);

        playerGlobalViewController.initGameModel(model);
        globalTab.setText("Global");
        globalTab.setContent(playerGlobalViewController.getRootComponent());

        root.getTabs().add(globalTab);


        model.getPlayerList().addListener(new ListChangeListener<PlayerModel>() {
            @Override
            public void onChanged(Change<? extends PlayerModel> change) {
                change.next();
                for (PlayerModel player : change.getAddedSubList()) {

                    PlayerSoloViewController playerSoloViewController = new PlayerSoloViewController();
                    playerSoloViewController.init(model, player);

                    // create and add tab
                    Tab tab = new Tab();
                    tab.setText(player.getName());
                    tab.setContent(playerSoloViewController.getRootComponent());
                    root.getTabs().add(tab);

                    playerGlobalViewController.addPlayer(player);

                }
            }
        });

        model.currentPlayerProperty().addListener((obs, oldPlayer, newPlayer) -> {
            if (root.getSelectionModel().getSelectedIndex() != 0){
                root.getSelectionModel().select(model.getPlayerList().indexOf(newPlayer) + 1);
            }
        });

    }

    public Parent getRootComponent(){
        return root;
    }

}
