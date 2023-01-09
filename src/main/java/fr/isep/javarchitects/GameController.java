package fr.isep.javarchitects;

import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.model.TestState;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller will handle the communication between the Game|Model and the GameUI|View.
 * Here we will send notifications to subscribers(Game UIs) to update the game state
 */
public class GameController {

    List<Subscriber> subscribers = new ArrayList<>();

    private Game game;
    private GameStateVisible gameStateVisible;
    private TestState testState = new TestState();

    /**
     * Adds a subscriber to the list
     * @param subscriber
     */
    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    /**
     * Remove subscriber from the list
     * @param subscriber
     */
    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    /**
     * Loop through the subscriber list to update
     */
    public void notifySubscribers(){
        for (Subscriber subscriber: subscribers) {
            subscriber.update(gameStateVisible);
        }
    }
    /**
     * test notification triggered by gameUI
     * @param event
     */
    public void triggerOkDepart(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        testState.labelString = stage.getTitle();
        notifySubscribers();
    }

    public GameController(Game game){
        this.game = game;
        game.setController(this);
    }

    public void sendFirstTestState(){
        this.gameStateVisible = game.getVisibleState();
        System.out.println(gameStateVisible.toString());
        notifySubscribers();
    }

}
