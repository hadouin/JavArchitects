package fr.isep.javarchitects;

import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.ProgressToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Visible state of the game that will be passed to graphical interface
 */
public class GameStateVisible {

    private List<PlayerVisible> players;
    private int currentPlayerID;

    private List<ConflictToken> conflictTokens;
    private List<ProgressToken> visibleProgressTokens;


    public static class Builder {
        // params obligatoires
        private final List<PlayerVisible> players;
        private final List<ConflictToken> conflictTokens;
        private final List<ProgressToken> visibleProgressTokens;
        // facultatifs
        private int currentPlayerID = 0;

        public Builder(List<PlayerVisible> players, List<ConflictToken> conflictTokens, List<ProgressToken> visibleProgressTokens) {
            this.players = players;
            this.conflictTokens = conflictTokens;
            this.visibleProgressTokens = visibleProgressTokens;
        }
        public Builder setCurrentPlayerID(int ID){
            this.currentPlayerID = ID; return this;
        }

        public GameStateVisible build(){
            return new GameStateVisible(this);
        }
    }

    GameStateVisible(Builder builder){
    }


}