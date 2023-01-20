package fr.isep.javarchitects.views;

import fr.isep.javarchitects.core.GameStateVisible;
import fr.isep.javarchitects.utils.Subscriber;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PlayerUI extends Stage implements Subscriber {

    private GameStateVisible gameStateVisible;
    private Pane rootPane;
    private Scene mainScene;

    PlayerUI(){

    }

    @Override
    public void update(GameStateVisible gameStateVisible) {

    }
}
