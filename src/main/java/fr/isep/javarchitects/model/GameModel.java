package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.Player;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class GameModel {
    private final ObservableList<PlayerModel> playerList = FXCollections.observableArrayList();
    private final ObjectProperty<PlayerModel> currentPlayer = new SimpleObjectProperty<>(null);


    public void setPlayers(PlayerModel... players){
        playerList.addAll(List.of(players));
    }

    public PlayerModel getCurrentPlayer() {
        return currentPlayer.get();
    }

    public ObjectProperty<PlayerModel> currentPlayerProperty() {
        return currentPlayer;
    }

    public final void setCurrentPlayer(PlayerModel player){
        currentPlayer.set(player);
    }

    public ObservableList<PlayerModel> getPlayerList() {
        return playerList;
    }
}
