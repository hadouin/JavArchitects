package fr.isep.javarchitects;

public class GameAction {
    public final String name;
    public final IVoidComplete action;


    public GameAction(String name, IVoidComplete todo) {
        this.name = name;
        this.action = todo;
    }
}
