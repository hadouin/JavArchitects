package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ListChangeListener;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class GameViewController {

    GameModel model;
    TabPane root = new TabPane();
    private Stage stage;
    GridPane globalContent = new GridPane();
    Tab globalTab = new Tab();
    private static final int COLUMNS = 3;

    public void init(GameModel model, Stage stage) {
        this.model = model;
        this.stage = stage;

        root.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        globalContent.addColumn(3);
        globalContent.addRow(3);
        root.setMaxWidth(820);
        root.setMaxHeight(600);
        globalTab.setText("Global");

        Scale scale = new Scale();
        scale.setX(0.33);
        scale.setY(0.33);
        globalContent.getTransforms().add(scale);

        globalTab.setContent(globalContent);



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

//
//                    // Add another to global view
//                    FXMLLoader playerGlobalViewLoader = new FXMLLoader(getClass().getResource("/views/PlayerView.fxml"));
//                    Node playerGlobalView = null;
//                    try {
//                        playerGlobalView = playerGlobalViewLoader.load();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    playerGlobalView.getTransforms();
//
//                    //add content
//                    int ordinal = model.getPlayerList().indexOf(player);
//                    int x = ordinal % COLUMNS;
//                    int y = ordinal / COLUMNS;
//                    globalContent.add(playerGlobalView, x, y);
//
//                    PlayerViewController playerGlobalViewController = playerGlobalViewLoader.getController();
//                    playerGlobalViewController.initModel(model);
//                    playerGlobalViewController.initPlayer(player);
                }
            }
        });

        model.currentPlayerProperty().addListener((obs, oldPlayer, newPlayer) -> {
            root.getSelectionModel().select(model.getPlayerList().indexOf(newPlayer) + 1);
        });

    }

    public Parent getRootComponent(){
        return root;
    }

}
