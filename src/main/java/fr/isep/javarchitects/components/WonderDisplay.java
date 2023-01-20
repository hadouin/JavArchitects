package fr.isep.javarchitects.components;

import fr.isep.javarchitects.core.Wonder;
import fr.isep.javarchitects.core.WonderFragment;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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
