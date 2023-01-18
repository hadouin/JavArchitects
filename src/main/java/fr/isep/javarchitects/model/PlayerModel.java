package fr.isep.javarchitects.model;

import fr.isep.javarchitects.core.Deck;
import fr.isep.javarchitects.core.Wonder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlayerModel {
    private final SimpleStringProperty name = new SimpleStringProperty(null);
    private final ObjectProperty<Wonder> wonder = new SimpleObjectProperty<>(null);
//    private final ObjectProperty<Deck> selfDeck = new SimpleObjectProperty<>(null);
//    private final ObjectProperty<Deck> rightDeck = new SimpleObjectProperty<>(null);


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
}
