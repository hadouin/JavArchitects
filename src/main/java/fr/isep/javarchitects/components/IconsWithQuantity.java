package fr.isep.javarchitects.components;

import fr.isep.javarchitects.utils.Icons;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;



public class IconsWithQuantity extends StackPane {

    public final Icons icon;
    public final NumberCircle numberCircle;

    public IconsWithQuantity(Icons icon, int number) {
        this.icon = icon;
        this.numberCircle = new NumberCircle(number, 8);
        ImageView imageViewIcon = new ImageView(icon.image);
        imageViewIcon.setPreserveRatio(true);
        imageViewIcon.setFitHeight(40);
        this.getChildren().add(imageViewIcon);
        this.getChildren().add(numberCircle);
        StackPane.setMargin(numberCircle, new Insets(25, 0, 0, 25));
    }
}
