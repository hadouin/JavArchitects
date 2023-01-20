package fr.isep.javarchitects.components;

import fr.isep.javarchitects.core.ConflictToken;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.List;

public class ConflictTokensHBox extends HBox {
    List<ConflictToken> conflictTokenList;

    public ConflictTokensHBox(List<ConflictToken> conflictTokenList){
        this.setSpacing(5);
        this.conflictTokenList = conflictTokenList;
        this.update();
    }

    private void update() {
        this.getChildren().clear();
        for (ConflictToken token : conflictTokenList) {
            String tokenImageString = token.getImage();
            Image image = new Image(getClass().getResourceAsStream(tokenImageString));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(50);
            imageView.setPreserveRatio(true);
            this.getChildren().add(imageView);
        }
    }

    public void setConflictTokenList(List<ConflictToken> conflictTokenList){
        this.conflictTokenList = conflictTokenList;
        update();
    }
}
