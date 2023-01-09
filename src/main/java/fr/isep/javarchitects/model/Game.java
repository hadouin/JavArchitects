package fr.isep.javarchitects.model;

//import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import fr.isep.javarchitects.Fenetres.GamePlayFieldWindow;
import fr.isep.javarchitects.GameController;

import java.util.ArrayList;


public class Game {

    private int nbPlayers;
    private ArrayList<Player> players;
    private GameController gameController;
    private int currentPlayerID = 0;
    private int nbRound = 1;

    public Game(int nbPlayers, ArrayList<String> playerNames) {
        this.nbPlayers = nbPlayers;
        gameController = new GameController(this);
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

    public GameController getGameController() {
        return gameController;
    }

    public void setNextPlayer() {
        currentPlayerID++;
        if (currentPlayerID >= this.nbPlayers) {
            this.currentPlayerID = 0;
            this.nbRound++;
        }
    }
}

