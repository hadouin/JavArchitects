package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class DeckDisplay extends AnchorPane {
    private ImageView cardImageView;
    private NumberCircle numberCircle;

    private Image image;
    private int nbCards;

    public DeckDisplay(Image image, int nbCards) {
        this.image = image;
        this.nbCards = nbCards;
        setupView();
    }

    private void setupView() {
        this.numberCircle = new NumberCircle(nbCards);
        AnchorPane.setBottomAnchor(numberCircle, -10.);
        AnchorPane.setRightAnchor(numberCircle, -10.);

        this.cardImageView = new ImageView(image);
        cardImageView.setFitWidth(100);
        cardImageView.setPreserveRatio(true);

        this.getChildren().addAll(cardImageView, numberCircle);
    }

    private void updateView() {
        this.cardImageView.setImage(image);
        this.numberCircle.setNumber(nbCards);
    }

    public void setImage(Image image) {
        this.image = image;
        updateView();
    }

    public void setNbCards(int nbCards) {
        this.nbCards = nbCards;
        updateView();
    }
}
