package fr.isep.javarchitects;

import fr.isep.javarchitects.model.Game;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * The controller will handle the business logic of the game.
 * Here we will send notifications to subscribers(Game UIs) to update the game state
 */
public class GameController {

    ArrayList<Subscriber> subscribers = new ArrayList<>();

    private GameStateInternal gameStateInternal ;
    private GameStateVisible gameStateVisible;
    private TestState testState = new TestState();
    private Game game;

    public GameStateInternal getGameStateInternal(){return gameStateInternal;}

    public GameController(Game game) {
        this.game = game;
        this.gameStateInternal = new GameStateInternal(game);
        this.gameStateVisible = new GameStateVisible(game);
    }

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
            subscriber.update(testState);
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

    public GameStateVisible getGameStateVisible() {
        return gameStateVisible;
    }
}
