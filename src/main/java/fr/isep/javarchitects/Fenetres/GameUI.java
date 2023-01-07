package fr.isep.javarchitects.Fenetres;

import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.Subscriber;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameUI extends Stage implements Subscriber {

    @Override
    public void update(GameStateVisible gameStateVisible) {
        System.out.println(gameStateVisible);
        Scene scene = this.getScene();
    }



}
