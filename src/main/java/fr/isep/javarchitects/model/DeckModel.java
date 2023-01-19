package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.CardBack;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.*;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class DeckModel {

    private ObjectProperty<Image> topDeckImage = new SimpleObjectProperty<>();
    private SimpleIntegerProperty nbCards = new SimpleIntegerProperty();
    private final ObservableList<Card> cardList = FXCollections.observableArrayList();

    private final CardBack cardBack;

    public DeckModel(CardBack cardBack, Card... cards) {
        this.cardList.addAll(cards);
        this.topDeckImage.set(cardList.get(0).getJavaFXImage());
        this.nbCards.set(cardList.size());
        this.cardBack = cardBack;
        this.cardList.addListener(new ListChangeListener<Card>() {
            @Override
            public void onChanged(Change<? extends Card> change) {
                topDeckImageProperty().set(cardList.get(0).getJavaFXImage());
                setNbCards(cardList.size());
            }
        });
    }

    public List<Card> getCards() {
        return cardList;
    }

    public void setCards(Card... cards) {
        this.cardList.setAll(cards);
    }

    public CardBack getCardBack() {
        return cardBack;
    }

    public Image getTopDeckImage() {
        return topDeckImage.get();
    }

    public ObjectProperty<Image> topDeckImageProperty() {
        return topDeckImage;
    }

    public void setTopDeckImage(Image topDeckImage) {
        this.topDeckImage.set(topDeckImage);
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
