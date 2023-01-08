package fr.isep.javarchitects;

import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.Player;
import fr.isep.javarchitects.model.ProgressToken;

import java.util.ArrayList;

/**
 * Visible state of the game that will be passed to graphical interface
 */
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
