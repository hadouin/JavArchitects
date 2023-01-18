package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.Wonder;
import fr.isep.javarchitects.model.WonderFragment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class WonderDisplay extends StackPane {
    Wonder wonder;

    public WonderDisplay(Wonder wonder){
        this.wonder = wonder;
        update();
    }

    private void update() {
        this.getChildren().clear();
        for (WonderFragment fragment :
                wonder.getWonderFragments()) {
            ImageView image = new ImageView(fragment.getImage());
            image.setPreserveRatio(true);
            image.setFitWidth(150);
            this.getChildren().add(image);
        }
    }


    public void setWonder(Wonder wonder) {
        this.wonder = wonder;
        update();
    }
}
