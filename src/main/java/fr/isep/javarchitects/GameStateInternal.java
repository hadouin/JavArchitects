package fr.isep.javarchitects;

import fr.isep.javarchitects.model.Game;

/**
 * The "memory" of the game it stores everything we know about the current state of the running game
 */
public class GameStateInternal {
    private Game game;


    public GameStateInternal(Game game){
        this.game = game;
    }

    //

}
