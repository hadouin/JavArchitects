package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.GameUtils;
import fr.isep.javarchitects.core.Player;
import fr.isep.javarchitects.core.command.DrawCard;
import fr.isep.javarchitects.core.command.GameAction;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.List;

public class GameModel {
    private final ObservableList<PlayerModel> playerList = FXCollections.observableArrayList();
    private final ObjectProperty<PlayerModel> currentPlayer = new SimpleObjectProperty<>(null);
    private int currentPlayerIndex = 0;
    private ObservableList<GameAction> gameActionList = FXCollections.observableArrayList();
    
    public void initializePlayers(String... names){
        for (int i = 0; i < names.length && i < 7; i++) {
            PlayerModel player = new PlayerModel();
            player.setName(names[i]);
            addPlayer(player);
        }
        GameUtils.setRandomWonder(playerList);
        GameUtils.setDecks(playerList);
        currentPlayer.set(playerList.get(currentPlayerIndex));
    }

    public void setDrawActions() {
        DrawCard currentPlayerDrawLeft = new DrawCard(this, "Draw Left", currentPlayer.get(), currentPlayer.get().getSelfDeck().getCards());
        DrawCard currentPlayerDrawCenter = new DrawCard(this, "Draw Center", currentPlayer.get(), currentPlayer.get().getOwnedCardList());
        DrawCard currentPlayerDrawRight = new DrawCard(this, "Draw Right", currentPlayer.get(), currentPlayer.get().getRightDeck().getCards());

        gameActionList.setAll(Arrays.asList(
                currentPlayerDrawLeft,
                currentPlayerDrawCenter,
                currentPlayerDrawRight
        ));
    }

    public void addPlayer(PlayerModel playerModel){
        playerList.add(playerModel);
    }
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

    public ObservableList<GameAction> getGameActionList() {
        return gameActionList;
    }

    public void setGameActionList(GameAction... gameActions) {
        this.gameActionList.setAll(gameActions);
    }
}
