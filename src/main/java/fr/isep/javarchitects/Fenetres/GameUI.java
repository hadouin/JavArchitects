package fr.isep.javarchitects.Fenetres;

import fr.isep.javarchitects.Subscriber;
import fr.isep.javarchitects.TestState;
import fr.isep.javarchitects.components.ProgressTokenPane;
import fr.isep.javarchitects.model.ProgressToken;
import fr.isep.javarchitects.model.ProgressTokens;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * GameUI is the main compent of ui view for the game.
 * It is a stage that will subscribe to the controller/publisher changes
 */
public class GameUI extends Stage implements Subscriber {
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1000;

    private Pane rootPane;
    private Scene mainScene;

    @Override
    public void update(TestState testState) {
        Pane root = (Pane) this.getScene().getRoot();
        root.getChildren().add(new Label(testState.labelString));
    }

    public GameUI(){
        this.rootPane = new AnchorPane();
        this.mainScene = new Scene(rootPane, WIDTH, HEIGHT);
        this.setTitle("JavArchitects");
        this.setScene(mainScene);
        setupGame();
    }

    private void setupGame(){
        setProgressTokens();
    }

    private void setProgressTokens() {
        Pane progressTokenView = new ProgressTokenPane(new ArrayList<>(ProgressTokens.TOKENS).subList(0,3));
        AnchorPane.setRightAnchor(progressTokenView, 2.);

        rootPane.getChildren().add(progressTokenView);
    }
}
