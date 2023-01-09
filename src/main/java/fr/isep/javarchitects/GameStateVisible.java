package fr.isep.javarchitects;

import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.Player;
import fr.isep.javarchitects.model.ProgressToken;

import java.util.ArrayList;

/**
 * Visible state of the game that will be passed to graphical interface
 */


public class GameStateVisible {
    private Game game;
    private int maxConflictTokens=0;
    private ArrayList<ConflictToken> conflictTokens = new ArrayList<>();

    public int getMaxConflictTokens() {
        return maxConflictTokens;
    }

    public GameStateVisible(Game game){
        this.game = game;
        this.maxConflictTokens = calcMaxConflictTokens();
        for (int i=0;i<maxConflictTokens;i++){
            conflictTokens.add(new ConflictToken(true));
        }
    }

    public String getConflictTokenImagePath(int tokenNumber){ // get path of the image (calculated on its status (peace/war)), tokenNumber is 0 for leftmost token
        String retValue="";
        retValue = this.conflictTokens.get(tokenNumber).getImageRessource();
        return retValue;
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