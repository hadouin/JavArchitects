package fr.isep.javarchitects.model;

import fr.isep.javarchitects.IVoidComplete;

public class GameAction {
    public final String name;
    public final IVoidComplete action;


    public GameAction(String name, IVoidComplete todo) {
        this.name = name;
        this.action = todo;
    }
}
