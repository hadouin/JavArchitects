package fr.isep.javarchitects.core;

import fr.isep.javarchitects.controllers.GameController;
import fr.isep.javarchitects.core.command.DrawCard;
import fr.isep.javarchitects.core.command.GameAction;
import fr.isep.javarchitects.model.DeckModel;

import java.util.*;
import java.util.stream.Collectors;


public class Game {
    private GameController gameController;
    private int nbPlayers;
    private List<Player> players;
    private int currentPlayerID = 0;
    private int nbRound = 1;
    private List<GameAction> activeActionsList = new ArrayList<>();
    private DeckModel centerDeck;

    public List<ConflictToken> conflictTokens = Arrays.asList(
            new ConflictToken(false),
            new ConflictToken(false),
            new ConflictToken(true)
    );
    private List<ProgressToken> progressTokenList = ProgressTokens.TOKENS.subList(5,11);

    // -----------------------------------------------------------------------------------------------------------------
    public Game(int nbPlayers, List<String> playerNames) {
        this.nbPlayers = nbPlayers;
        this.players = new ArrayList<>();
        for(int i = 0; i < this.nbPlayers; i++){
            players.add(new Player(playerNames.get(i), i, WonderFactory.Alexandria.createWonder()));
        }
        GameUtils.setRandomWonder(players);
        GameUtils.setDecks(players);
        this.centerDeck = DeckFactory.Extra.createDeck();
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerID);
    }

    public void setController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public Player getCurrentPlayerID() {
        return players.get(currentPlayerID);
    }

    /**
     * @return the visible elements of the current state of the game
     */
    public GameStateVisible getVisibleState() {
        return new GameStateVisible(
                players.stream()
                        .map(Player::getVisibleState)
                        .collect(Collectors.toList()),
                0,
                conflictTokens,
                progressTokenList.subList(0,3),
                activeActionsList
        );
    }
}

