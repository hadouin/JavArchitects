package fr.isep.javarchitects;

import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.Joueur;
import fr.isep.javarchitects.model.ProgressToken;

import java.util.ArrayList;

/**
 * Visble state of the game that will be passed to graphical interface
 */
public class GameStateVisible {
    private ArrayList<Joueur> joueurs;
    private int currentPlayerID;
    private ArrayList<ConflictToken> conflictTokens;
    private ArrayList<ProgressToken> visibleProgressTokens;


    public static class Builder {
        // params obligatoires
        private final ArrayList<Joueur> joueurs;
        // facultatifs
        private int currentPlayerID = 0;

        public Builder(ArrayList<Joueur> joueurs) {
            this.joueurs = joueurs;
        }
        public Builder setCurrentPlayerID(int ID){
            this.currentPlayerID = ID; return this;
        }

        public GameStateVisible build(){
            return new GameStateVisible(this);
        }
    }

    GameStateVisible(Builder builder){
        this.joueurs = builder.joueurs;
    }


}
