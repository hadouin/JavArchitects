package fr.isep.javarchitects.components;

import fr.isep.javarchitects.command.GameAction;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class GameLogComponent extends ListView<GameAction> {
    public GameLogComponent(){
        this.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(GameAction item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    // allow wrapping
                    setWrapText(true);

                    setText(item.toString());
                }
            }
        });
    }
}
