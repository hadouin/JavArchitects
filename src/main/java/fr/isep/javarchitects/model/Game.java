package fr.isep.javarchitects.model;

//import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import fr.isep.javarchitects.GameController;
import fr.isep.javarchitects.GameStateVisible;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Game {
    private GameController gameController;

    private int nbPlayers;
    private List<Player> players;
    private int currentPlayerID = 0;
    private int nbRound = 1;

    public List<ConflictToken> conflictTokens = Arrays.asList(
            new ConflictToken(false),
            new ConflictToken(false),
            new ConflictToken(true)
    );
    private List<ProgressToken> progressTokenList = ProgressTokens.TOKENS.subList(5,11);


    public Game(int nbPlayers, List<String> playerNames) {
        this.nbPlayers = nbPlayers;
        this.players = new ArrayList<>();
        for(int i = 0; i < this.nbPlayers; i++){
            players.add(new Player(playerNames.get(i), i, Wonder.Alexandrie));
        }
    }

    public void setController(GameController gameController) {
        this.gameController = gameController;
    }

    public void startGame(){};

    public List<Player> getPlayers() {
        return players;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public Player getCurrentPlayerID() {
        return players.get(currentPlayerID);
    }

    public void setNextPlayer() {
        currentPlayerID++;
        if (currentPlayerID >= this.nbPlayers) {
            this.currentPlayerID = 0;
            this.nbRound++;
        }
    }

    /**
     * 09/01/23 Moved from GameStateVisible
     * @param nbPlayers number of players in the game
     * @return the number of conflict tokens for the game
     */
    private int calcMaxConflictTokens(int nbPlayers){
        int ret=0;
        switch(nbPlayers){
            case 2:
            case 3:
                ret=3;
                break;
            case 4:
                ret=4;
                break;
            case 5:
                ret=5;
                break;
            case 6:
            case 7:
                ret=6;
                break;
        }
        return ret;
    }

    public GameStateVisible getVisibleState() {
        return new GameStateVisible(
                players.stream()
                        .map(Player::getVisibleState)
                        .collect(Collectors.toList()),
                0,
                conflictTokens,
                progressTokenList.subList(0,3),
                Arrays.asList(
                        new GameAction("Action 1", () -> {}),
                        new GameAction("Back", () -> {})
                )
        );
    }
}

