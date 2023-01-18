package fr.isep.javarchitects.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;

public class PlayerModel {
    private final SimpleStringProperty name = new SimpleStringProperty(null);

    public void setName(String name){
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
