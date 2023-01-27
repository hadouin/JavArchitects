package fr.isep.javarchitects.components;

import fr.isep.javarchitects.utils.images.Icons;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PointCounter extends StackPane {
    public final Icons icon;
    public final Label counter;

    public PointCounter(Icons icon, int count) {
        this.icon = icon;
        this.counter = new Label();
        counter.setText(Integer.toString(count));

        ImageView image = new ImageView(icon.image);
        image.setFitHeight(40);
        image.setPreserveRatio(true);
        this.getChildren().addAll(image, counter);
    }
}
