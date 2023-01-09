package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.Wonder;
import fr.isep.javarchitects.model.WonderFragment;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Collections;

public class WonderDisplay extends VBox {
    Wonder wonder;

    public WonderDisplay(Wonder wonder){
        this.wonder = wonder;
        update();
    }

    private void update() {
        switch(wonder.getID()){
            case 0:
                setAlexandrie();
                break;
            default:
                setAlexandrie();
                break;
        }
    }
    
    private void setAlexandrie(){
        this.setAlignment(Pos.CENTER);
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth()/3);
            imageView.setPreserveRatio(true);

            this.getChildren().add(imageView);
        }
    }

}
