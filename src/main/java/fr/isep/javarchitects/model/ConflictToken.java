package fr.isep.javarchitects.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableStringValue;

public class ConflictToken {
    private final SimpleStringProperty imageRessource = new SimpleStringProperty();
    private final SimpleBooleanProperty peace = new SimpleBooleanProperty();

    public ConflictToken(boolean peace){
        this.peace.set(peace);
        updateImage();
    }

    public void setWar(){
        peace.set(false);
        updateImage();
    }

    public void setPeace(){
        peace.set(true);
        updateImage();
    }

    private void updateImage(){
        if (this.peace.get()){
            this.imageRessource.set("/images/tokens/token-conflict-peace.png");
        } else {
            this.imageRessource.set("/images/tokens/token-conflict-war.png");
        }
    }

    public String getImage() {
        return this.imageRessource.get();
    }
    
    public boolean isPeace(){
        return peace.get();
    }

    public ObservableBooleanValue peaceProperty() {
        return peace;
    }
    public ObservableStringValue imageResourceProperty() {
        return imageRessource;
    }

    @Override
    public String toString(){
        return peace.get() ? "peace" : "war";
    }
}
