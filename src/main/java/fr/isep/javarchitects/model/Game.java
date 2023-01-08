package fr.isep.javarchitects.model;

import fr.isep.javarchitects.Fenetres.FenetrePrincipale;

import java.util.ArrayList;


public class Game {

    private int nbPlayers;
    private ArrayList<Player> players;
    private int currentPlayerID = 0;
    private int nbRound = 1;

    public Game(int nbPlayers, ArrayList<String> playerNames, FenetrePrincipale fp) {
        this.nbPlayers = nbPlayers;
        this.players = new ArrayList<>();
        for(int i = 0; i < this.nbPlayers; i++) {
            players.add(new Player(playerNames.get(i), i));
        }
    }
    public void startGame(){};

    public ArrayList<Player> getPlayers() {
        return players;
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
}

