package fr.isep.javarchitects;

import fr.isep.javarchitects.model.Joueur;
import fr.isep.javarchitects.model.WonderFragment;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    ArrayList<Subscriber> subscribers = new ArrayList<>();
    private GameStateInternal gameStateInternal;
    private GameStateVisible visibleState;

    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public void notifySubscribers(){
        for (Subscriber subscriber: subscribers) {
            subscriber.update(visibleState);
        }
    }


}
