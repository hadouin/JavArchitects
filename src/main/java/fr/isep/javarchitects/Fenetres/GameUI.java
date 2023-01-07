package fr.isep.javarchitects.Fenetres;

import fr.isep.javarchitects.GameStateVisible;
import fr.isep.javarchitects.Subscriber;
import fr.isep.javarchitects.TestState;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameUI extends Stage implements Subscriber {

    @Override
    public void update(TestState testState) {
        Pane root = (Pane) this.getScene().getRoot();
        root.getChildren().add(new Label(testState.labelString));
    }

}
