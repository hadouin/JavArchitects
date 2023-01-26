package fr.isep.javarchitects.components;

import fr.isep.javarchitects.components.NumberCircle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class DeckControl extends VBox {

    private final AnchorPane root = new AnchorPane();
    private ImageView cardImageView;
    private NumberCircle numberCircle;
    private SimpleIntegerProperty nbCards = new SimpleIntegerProperty();
    private ObjectProperty<Image> imageObject = new SimpleObjectProperty<>();

    public DeckControl(){
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(root);

        this.cardImageView = new ImageView(imageObject.get());
        cardImageView.setFitWidth(75);
        cardImageView.setPreserveRatio(true);

        this.numberCircle = new NumberCircle(nbCards.get());
        AnchorPane.setBottomAnchor(numberCircle, -10.);
        AnchorPane.setRightAnchor(numberCircle, -10.);

        root.getChildren().addAll(cardImageView, numberCircle);

        nbCards.addListener((observableValue, oldNumber, newNumber) -> {
            if (newNumber.intValue() <= 1){
                root.getChildren().remove(numberCircle);
            } else if (oldNumber.intValue() <= 1){
                root.getChildren().set(1, numberCircle);
            }
            numberCircle.setNumber(newNumber.intValue());
        });
        imageObject.addListener((observableValue, oldImage, newImage) -> {
            cardImageView.setImage(newImage);
        });
    }

    public void setFitWidth(double size){
        cardImageView.setFitWidth(size);
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
