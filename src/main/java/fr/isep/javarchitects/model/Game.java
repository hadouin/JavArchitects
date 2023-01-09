package fr.isep.javarchitects.model;

//import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import fr.isep.javarchitects.Fenetres.GamePlayFieldWindow;
import fr.isep.javarchitects.GameController;

import java.util.ArrayList;


public class Game {
    private GameController gameController;

    private int nbPlayers;
    private ArrayList<Player> players;
    private int currentPlayerID = 0;
    private int nbRound = 1;

    public Game(int nbPlayers, ArrayList<String> playerNames) {
        this.nbPlayers = nbPlayers;
        gameController = new GameController();
        this.players = new ArrayList<>();
        for(int i = 0; i < this.nbPlayers; i++){
            players.add(new Player(playerNames.get(i), i));
        }
    }
    public void startGame(){};

    public ArrayList<Player> getPlayers() {
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
}

