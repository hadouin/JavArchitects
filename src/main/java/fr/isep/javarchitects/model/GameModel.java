package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.*;
import fr.isep.javarchitects.model.command.*;
import fr.isep.javarchitects.utils.ImmutableCardByTypeCounts;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

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
    private final ObservableList<ProgressToken> progressTokensList = FXCollections.observableArrayList(ProgressTokens.getNewList());
    private final ObservableList<ConflictToken> conflictTokensList = FXCollections.observableArrayList(new Callback<ConflictToken, Observable[]>() {
        @Override
        public Observable[] call(ConflictToken conflictToken) {
            return new Observable[] {conflictToken.imageResourceProperty()};
        }
    });
    
    public void initializePlayers(String... names){
        ArrayList<PlayerModel> initPlayerList = new ArrayList<>();
        for (int i = 0; i < names.length && i < 7; i++) {
            PlayerModel player = new PlayerModel();
            player.setName(names[i]);
            initPlayerList.add(player);
        }
        for (int i = 0; i < GameUtils.getMaxConflictTokens(initPlayerList.size()); i++){
            this.conflictTokensList.add(new ConflictToken(true));
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

    public ObservableList<ProgressToken> getProgressTokensList() {
        return progressTokensList;
    }
    public List<ProgressToken> getVisibleTokens(){
        return progressTokensList.subList(0,3);
    }

    public void chooseProgress() {
        ImmutableCardByTypeCounts immutableCardByTypeCounts = currentPlayer.get().getAvailableCardCounters();
        if (immutableCardByTypeCounts.progressLawCount >= 2) {
            ArrayList<Card> cards = new ArrayList<Card>(List.of(Card.CardScienceLaw, Card.CardScienceLaw));
            currentPlayer.get().removeCardByTypeCounts(new ImmutableCardByTypeCounts(cards));
            this.setProgressChoices();
            return;
        }
        if (immutableCardByTypeCounts.progressArchitectCount >= 2) {
            ArrayList<Card> cards = new ArrayList<Card>(List.of(Card.CardScienceArchitect, Card.CardScienceArchitect));
            currentPlayer.get().removeCardByTypeCounts(new ImmutableCardByTypeCounts(cards));
            this.setProgressChoices();
            return;
        }
        if (immutableCardByTypeCounts.progressMechanicCount >= 2){
            ArrayList<Card> cards = new ArrayList<Card>(List.of(Card.CardScienceMechanic, Card.CardScienceMechanic));
            currentPlayer.get().removeCardByTypeCounts(new ImmutableCardByTypeCounts(cards));
            this.setProgressChoices();
            return;
        }
        if (immutableCardByTypeCounts.progressMechanicCount >= 1 &&
                immutableCardByTypeCounts.progressArchitectCount >= 1 &&
                immutableCardByTypeCounts.progressLawCount >= 1){
            ArrayList<Card> cards = new ArrayList<Card>(List.of(Card.CardScienceMechanic, Card.CardScienceLaw, Card.CardScienceArchitect));
            currentPlayer.get().removeCardByTypeCounts(new ImmutableCardByTypeCounts(cards));
            this.setProgressChoices();
            return;
        }
        this.endTurn();
    }

    private void endTurn() {
        this.nextPlayer();
        this.setDrawActions();
    }

    private void setProgressChoices() {
        this.gameActionList.clear();
        for (ProgressToken token :
                this.getVisibleTokens()) {
            this.gameActionList.add(new ResearchProgress(this, getCurrentPlayer(), token));
        }
    }

    public ObservableList<ConflictToken> getConflictTokens() {
        return conflictTokensList;
    }

    public void updateConflictState(Card card) {
        for (int i = 0; i < card.cornCount; i++){
            if (!flipFirstPeaceToken()){
                startWar();
                playerList.forEach(PlayerModel::removeHorns);
                conflictTokensList.forEach(ConflictToken::setPeace);
                break;
            }
        }

        endTurn();
    }

    private void startWar() {
        for (int i = 0; i < playerList.size(); i++) {
            PlayerModel currentPlayer = playerList.get(i);
            PlayerModel prevPlayer = i != 0 ? playerList.get(i - 1) : playerList.get(playerList.size() - 1);
            PlayerModel nextPlayer = i != playerList.size() - 1 ? playerList.get(i + 1) : playerList.get(0) ;
            if (currentPlayer.getPlayerWarPoints() > nextPlayer.getPlayerWarPoints()){
                currentPlayer.addBattleToken(1);
            }
            if (currentPlayer.getPlayerWarPoints() > prevPlayer.getPlayerWarPoints()){
                currentPlayer.addBattleToken(1);
            }
        }
    }

    private boolean flipFirstPeaceToken() {

        ConflictToken firstObject = conflictTokensList.stream()
                .filter(ConflictToken::isPeace)
                .findFirst()
                .orElse(null);
        if (firstObject == null){
            return false;
        }
        firstObject.setWar();
        return true;
    }
}
