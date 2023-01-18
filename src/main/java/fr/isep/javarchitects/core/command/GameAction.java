package fr.isep.javarchitects.core.command;

import fr.isep.javarchitects.core.Game;

public abstract class GameAction {
    public final String name;
    public final Game game;
    GameAction(String name, Game game){
        this.name = name;
        this.game = game;
    }
    public abstract void execute();
}
