package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.model.TestState;
import fr.isep.javarchitects.model.command.GameAction;
import fr.isep.javarchitects.utils.Subscriber;
import fr.isep.javarchitects.views.GameUI;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * The controller will handle the communication between the Game|Model and the GameUI|View.
 * Here we will send notifications to subscribers(Game UIs) to update the game state
 */
public class GameController {
    private Game game;
    private GameStateVisible gameStateVisible = GameStateVisible.BASE_STATE;

    public GameController(Game game){
        this.game = game;
        game.setController(this);
        GameUI gameUI = new GameUI(this.gameStateVisible);
        subscribe(gameUI);
        gameUI.show();
    }

    // Observers
    List<Subscriber> subscribers = new ArrayList<>();
    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }
    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }
    public void notifySubscribers(){
        for (Subscriber subscriber: subscribers) {
            subscriber.update(gameStateVisible);
        }
    }

    // Commands
    private Deque<GameAction> actions = new ArrayDeque<>();
    public void addAction(GameAction action){
        actions.add(action);
    }
    public boolean doNextAction(){
        actions.pop().execute();
        return !actions.isEmpty();
    }

}
