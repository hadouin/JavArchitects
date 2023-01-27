package fr.isep.javarchitects.command;

import fr.isep.javarchitects.utils.ObservableStack;
import javafx.collections.ObservableList;

public class GameActionHistory {
    private final ObservableStack<GameAction> history = new ObservableStack<>();

    public void push(GameAction c) {
        history.push(c);
    }

    public GameAction pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }

    public ObservableList<GameAction> historyStack(){
        return history;
    }

}