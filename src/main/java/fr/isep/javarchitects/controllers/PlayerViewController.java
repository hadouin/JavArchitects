package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.components.ConflictTokensHBox;
import fr.isep.javarchitects.components.ProgressTokenPane;
import fr.isep.javarchitects.controls.DeckControl;
import fr.isep.javarchitects.controls.InventoryControl;
import fr.isep.javarchitects.controls.WonderDisplayControl;
import fr.isep.javarchitects.core.ProgressToken;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.model.command.GameAction;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PlayerViewController {
    @FXML
    Label informationLabel;
    @FXML
    HBox buttonHBox;
    @FXML
    HBox generalHBox;
    @FXML
    HBox headerHBox;
    @FXML
    HBox warTokensHBox;
    @FXML
    HBox progressTokensHBox;
    @FXML
    ListView<GameAction> logListView;

    DeckControl leftDeckDisplay = new DeckControl();
    DeckControl rightDeckDisplay = new DeckControl();
    DeckControl centerDeckDisplay = new DeckControl();
    WonderDisplayControl wonderDisplayControl = new WonderDisplayControl();

    ProgressTokenPane progressTokenPane;
    ConflictTokensHBox conflictTokensHBox;

    private PlayerModel player;

    GameModel model; // DataModel

    public void initModel(GameModel model){
        // ensure model is set once
        if (this.model != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        this.progressTokenPane = new ProgressTokenPane(model.getVisibleTokens());
        headerHBox.getChildren().add(2, progressTokenPane);

        this.conflictTokensHBox = new ConflictTokensHBox(model.getConflictTokens());
        headerHBox.getChildren().add(0, conflictTokensHBox);
        model.getProgressTokensList().addListener(new ListChangeListener<ProgressToken>() {
            @Override
            public void onChanged(Change<? extends ProgressToken> change) {
                progressTokenPane.setVisibleTokens(model.getVisibleTokens());
            }
        });

        logListView.setCellFactory(param -> new ListCell<GameAction>(){
            @Override
            protected void updateItem(GameAction item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item==null) {
                    setGraphic(null);
                    setText(null);
                    // other stuff to do...
                }else{
                    // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());

                    // allow wrapping
                    setWrapText(true);

                    setText(item.toString());
                }
            }
        });

        logListView.setItems(model.gameActionHistoryProperty().get().historyStack());

        model.getGameActionList().addListener(new ListChangeListener<GameAction>() {
            @Override
            public void onChanged(Change<? extends GameAction> change) {
                buttonHBox.getChildren().clear();
                if (model.currentPlayerProperty().get() != player){
                    return;
                }
                for (GameAction gameAction: change.getList()) {
                    Button button = new Button(gameAction.name);
                    button.setOnAction(actionEvent -> {
                        model.executeCommand(gameAction);
                    });
                    buttonHBox.getChildren().add(button);
                }
            }
        });
    }

    public void initPlayer(PlayerModel playerModel){
        if (this.player != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.player = playerModel;

        VBox wonderVBox = new VBox();
        wonderVBox.getChildren().add(wonderDisplayControl);
        FXMLLoader inventoryLoader = new FXMLLoader(getClass().getResource("/views/InventoryControl.fxml"));
        Parent parent = null;
        try {
            parent = inventoryLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InventoryControl inventoryControl = inventoryLoader.getController();
        inventoryControl.initModel(player);
        wonderVBox.getChildren().add(parent);
        this.generalHBox.getChildren().addAll(leftDeckDisplay, wonderVBox, rightDeckDisplay);

        informationLabel.textProperty().bind(player.nameProperty());
        wonderDisplayControl.wonderObjectPropertyProperty().bind(player.wonderProperty());
        leftDeckDisplay.imageObjectProperty().bind(player.selfDeckProperty().get().topDeckImageProperty());
        leftDeckDisplay.nbCardsProperty().bind(player.selfDeckProperty().get().nbCardsProperty());
        rightDeckDisplay.imageObjectProperty().bind(player.rightDeckProperty().get().topDeckImageProperty());
        rightDeckDisplay.nbCardsProperty().bind(player.rightDeckProperty().get().nbCardsProperty());

        centerDeckDisplay.imageObjectProperty().setValue(model.centerDeckProperty().get().getCardBack().image);
        centerDeckDisplay.nbCardsProperty().bind(model.centerDeckProperty().get().nbCardsProperty());
        centerDeckDisplay.setFitWidth(50);
        this.headerHBox.getChildren().set(1, centerDeckDisplay);

    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }
}
