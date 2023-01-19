package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.DeckFactory;
import fr.isep.javarchitects.core.GameUtils;
import fr.isep.javarchitects.model.command.BuildWonderFragUsingCards;
import fr.isep.javarchitects.model.command.DrawCard;
import fr.isep.javarchitects.model.command.GameAction;
import fr.isep.javarchitects.model.command.GameActionHistory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameModel {
    private final ObservableList<PlayerModel> playerList = FXCollections.observableArrayList();
    private final ObjectProperty<PlayerModel> currentPlayer = new SimpleObjectProperty<>(null);
    private final ObjectProperty<DeckModel> centerDeck = new SimpleObjectProperty<>();
    private int currentPlayerIndex = 0;
    private final ObservableList<GameAction> gameActionList = FXCollections.observableArrayList();

    private final ObservableObjectValue<GameActionHistory> gameActionHistory = new SimpleObjectProperty<>(new GameActionHistory());
    
    public void initializePlayers(String... names){
        ArrayList<PlayerModel> initPlayerList = new ArrayList<>();
        for (int i = 0; i < names.length && i < 7; i++) {
            PlayerModel player = new PlayerModel();
            player.setName(names[i]);
            initPlayerList.add(player);
        }
        GameUtils.setRandomWonder(initPlayerList);
        GameUtils.setDecks(initPlayerList);
        centerDeck.setValue(DeckFactory.Extra.createDeck());
        playerList.setAll(initPlayerList);
        currentPlayer.set(playerList.get(currentPlayerIndex));
        setDrawActions();
    }

    public void setDrawActions() {
        DrawCard currentPlayerDrawLeft = new DrawCard(this, "Draw Left", currentPlayer.get(), currentPlayer.get().getSelfDeck().getCards());
        DrawCard currentPlayerDrawCenter = new DrawCard(this, "Draw Center", currentPlayer.get(), centerDeck.get().getCards());
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

    public ObjectProperty<DeckModel> centerDeckProperty() {
        return centerDeck;
    }
    public ObservableObjectValue<GameActionHistory> gameActionHistoryProperty(){
        return gameActionHistory;
    }

    public void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex > playerList.size() - 1){
            currentPlayerIndex = 0;
        }
        setCurrentPlayer(playerList.get(currentPlayerIndex));
        setDrawActions();
    }

    public void buildWonder() {
        List<BuildWonderFragUsingCards> buildActions = GameUtils.getBuildingCombinations(getCurrentPlayer(), this);
        if (buildActions.size() > 0){
            gameActionList.setAll(buildActions);
        } else {
            nextPlayer();
            setDrawActions();
        }
    }

    public void executeCommand(GameAction gameAction){
        if (gameAction.execute()){
            gameActionHistory.get().push(gameAction);
        }
    }
}
