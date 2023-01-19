package fr.isep.javarchitects.controls;

import fr.isep.javarchitects.components.NumberCircle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DeckControl extends AnchorPane {

    private ImageView cardImageView;
    private NumberCircle numberCircle;
    private SimpleIntegerProperty nbCards = new SimpleIntegerProperty();
    private ObjectProperty<Image> imageObject = new SimpleObjectProperty<>();

    public DeckControl(){
        this.setMaxHeight(150);

        this.numberCircle = new NumberCircle(nbCards.get());
        AnchorPane.setBottomAnchor(numberCircle, -10.);
        AnchorPane.setRightAnchor(numberCircle, -10.);

        this.cardImageView = new ImageView(imageObject.get());
        cardImageView.setFitWidth(75);
        cardImageView.setPreserveRatio(true);
        AnchorPane.setBottomAnchor(cardImageView, 0.);

        this.getChildren().addAll(cardImageView, numberCircle);

        nbCards.addListener((observableValue, oldNumber, newNumber) -> {
            numberCircle.setNumber(newNumber.intValue());
        });
        imageObject.addListener((observableValue, oldImage, newImage) -> {
            cardImageView.setImage(newImage);
        });
    }


    public Image getImageObject() {
        return imageObject.get();
    }

    public ObjectProperty<Image> imageObjectProperty() {
        return imageObject;
    }

    public void setImageObject(Image imageObject) {
        this.imageObject.set(imageObject);
    }

    public int getNbCards() {
        return nbCards.get();
    }

    public SimpleIntegerProperty nbCardsProperty() {
        return nbCards;
    }

    public void setNbCards(int nbCards) {
        this.nbCards.set(nbCards);
    }
}
