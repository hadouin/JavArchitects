package fr.isep.javarchitects;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameController {

    ArrayList<Subscriber> subscribers = new ArrayList<>();
    private GameStateInternal gameStateInternal;
    private GameStateVisible visibleState;
    private TestState testState = new TestState();

    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public void notifySubscribers(){
        for (Subscriber subscriber: subscribers) {
            subscriber.update(testState);
        }
    }


    public void triggerOkDepart(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        testState.labelString = stage.getTitle();
        notifySubscribers();
    }
}
