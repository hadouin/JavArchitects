package fr.isep.javarchitects.model.command;

import fr.isep.javarchitects.model.GameModel;

public abstract class GameAction {
    public final String name;
    public final GameModel game;
    protected GameAction(String name, GameModel game){
        this.name = name;
        this.game = game;
    }
    public abstract boolean execute();

}
