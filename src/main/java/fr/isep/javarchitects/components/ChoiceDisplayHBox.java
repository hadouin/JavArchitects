package fr.isep.javarchitects.components;

import fr.isep.javarchitects.command.GameAction;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class ChoiceDisplayHBox extends HBox {
    private List<GameAction> gameActionList;

    public ChoiceDisplayHBox(List<GameAction> gameActionList){
        this.setSpacing(5);
        setGameActionList(gameActionList);
    }

    public void setGameActionList(List<GameAction> gameActionList) {
        this.gameActionList = gameActionList;
        update();
    }

    private void update() {
        if (this.gameActionList == null){
            return;
        }
        this.getChildren().clear();
        for (GameAction gameAction : gameActionList) {
            Button button = new Button(gameAction.name);
            button.setOnAction(e -> {
                gameAction.execute();
            });
            this.getChildren().add(button);
        }
    }

    public void clearChoices(){
        this.getChildren().clear();
    }
}
