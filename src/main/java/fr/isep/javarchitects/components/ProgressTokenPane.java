package fr.isep.javarchitects.components;

import fr.isep.javarchitects.core.ProgressToken;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ProgressTokenPane extends VBox {

    List<ProgressToken> visibletokens = new ArrayList<>();
    ImageView imageIP;
    Label descriptionLabel;
    HBox tokenHBox = new HBox();

    /**
     * a VBox that has the Hbox of tken images and the description label
     * @param visibletokens list of the three visible tokens
     */
    public ProgressTokenPane(List<ProgressToken> visibletokens){
        this.setAlignment(Pos.TOP_RIGHT);
        tokenHBox.setAlignment(Pos.TOP_RIGHT);
        this.descriptionLabel = new Label("description");
        // Image of unknown progress token
        this.imageIP = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens-progress/back/token-back.png")));
        imageIP.setFitWidth(imageIP.getImage().getWidth() / 3);
        imageIP.setPreserveRatio(true);

        this.getChildren().add(tokenHBox);
        this.getChildren().add(descriptionLabel);
        setVisibleTokens(visibletokens);
    }

    private void updateView(){
        tokenHBox.getChildren().clear();
        tokenHBox.getChildren().add(imageIP);
        addTokensToView();
    }

    private void addTokensToView() {
        for (ProgressToken token: visibletokens) {
            Image tokenImage = new Image(getClass().getResourceAsStream(token.imageResource));
            ImageView tokenImageView = new ImageView(tokenImage);
            tokenImageView.setOnMouseEntered(event -> {
                descriptionLabel.setText(token.effectDescription);
            });

            tokenImageView.setOnMouseExited(event1 -> {
                descriptionLabel.setText("");
            });

            tokenImageView.setFitWidth(tokenImageView.getImage().getWidth() / 3);
            tokenImageView.setPreserveRatio(true);

            tokenHBox.getChildren().add(tokenImageView);
        }
    }

    public void setVisibleTokens(List<ProgressToken> visibletokens){
        this.visibletokens = visibletokens;
        updateView();
    }
}
