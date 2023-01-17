package fr.isep.javarchitects.model.command;

public abstract class GameAction {
    public final String name;
    GameAction(String name){
        this.name = name;
    }
    public abstract void execute();
}
