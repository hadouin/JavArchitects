package fr.isep.javarchitects;

import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.Player;
import fr.isep.javarchitects.model.ProgressToken;

import java.util.ArrayList;

/**
 * Visible state of the game that will be passed to graphical interface
 */

//julie : actuellement visiblke contient des choses je crois que l'integralité de players devrait être dans Internal

public class GameStateVisible {
    private Game game;
    private int maxConflictTokens=0;

    public int getMaxConflictTokens() {
        return maxConflictTokens;
    }

    public GameStateVisible(Game game){
        this.game = game;
        this.maxConflictTokens = calcMaxConflictTokens();
    }

    private int calcMaxConflictTokens(){
        int ret=0;
        switch(this.game.getNbPlayers()){
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

/*
public class GameStateVisible {
    private ArrayList<Player> players;
    private int currentPlayerID;
    private ArrayList<ConflictToken> conflictTokens;
    private ArrayList<ProgressToken> visibleProgressTokens;


    public static class Builder {
        // params obligatoires
        private final ArrayList<Player> players;
        // facultatifs
        private int currentPlayerID = 0;

        public Builder(ArrayList<Player> players) {
            this.players = players;
        }
        public Builder setCurrentPlayerID(int ID){
            this.currentPlayerID = ID; return this;
        }

        public GameStateVisible build(){
            return new GameStateVisible(this);
        }
    }

    GameStateVisible(Builder builder){
        this.players = builder.players;
    }


}
*/