package fr.isep.javarchitects.model.command;

import fr.isep.javarchitects.model.Game;

public abstract class GameAction {
    public final String name;
    public final Game game;
    GameAction(String name, Game game){
        this.name = name;
        this.game = game;
    }
    public abstract void execute();
}
