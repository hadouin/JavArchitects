package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.Deck;
import fr.isep.javarchitects.core.DeckFactory;
import fr.isep.javarchitects.core.Wonder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerModel {
    private final SimpleStringProperty name = new SimpleStringProperty(null);
    private final ObjectProperty<Wonder> wonder = new SimpleObjectProperty<>(null);
    private final ObjectProperty<DeckModel> selfDeck = new SimpleObjectProperty<>(null);
    private final ObjectProperty<DeckModel> rightDeck = new SimpleObjectProperty<>(null);
    private final ObservableList<Card> ownedCardList = FXCollections.observableArrayList();


    public void setName(String name){
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setWonder(Wonder wonder){
        this.wonder.set(wonder);
    }
    public Wonder getWonder() {
        return wonder.get();
    }

    public ObjectProperty<Wonder> wonderProperty() {
        return wonder;
    }

    public DeckModel getRightDeck() {
        return rightDeck.get();
    }

    public ObjectProperty<DeckModel> rightDeckProperty() {
        return rightDeck;
    }

    public void setRightDeck(DeckModel rightDeck) {
        this.rightDeck.set(rightDeck);
    }

    public DeckModel getSelfDeck() {
        return selfDeck.get();
    }

    public ObjectProperty<DeckModel> selfDeckProperty() {
        return selfDeck;
    }

    public void setSelfDeck(DeckModel selfDeck) {
        this.selfDeck.set(selfDeck);
    }

    public ObservableList<Card> getOwnedCardList(){
        return ownedCardList;
    }
    public void addCard(Card card) {
        ownedCardList.add(card);
    }
}