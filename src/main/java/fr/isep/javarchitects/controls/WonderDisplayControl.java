package fr.isep.javarchitects.controls;

import fr.isep.javarchitects.core.Wonder;
import fr.isep.javarchitects.core.WonderFragment;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class WonderDisplayControl extends StackPane {
    private final ObjectProperty<Wonder> wonderObjectProperty = new SimpleObjectProperty<>(null);

    public WonderDisplayControl(){
        wonderObjectProperty.addListener((obs, oldWonder, newWonder) -> {
            setupWonder(newWonder);
            newWonder.getWonderFragmentList().addListener(new ListChangeListener<WonderFragment>() {
                @Override
                public void onChanged(Change<? extends WonderFragment> change) {
                    setupWonder(newWonder);
                }
            });
        });
    }

    private void setupWonder(Wonder newWonder) {
        getChildren().clear();
        for (WonderFragment fragment :
                newWonder.getWonderFragments()) {
            ImageView image = new ImageView(fragment.getImage());
            image.setPreserveRatio(true);
            image.setFitWidth(150);
            getChildren().add(image);
        }
    }

    public Wonder getWonderObjectProperty() {
        return wonderObjectProperty.get();
    }

    public ObjectProperty<Wonder> wonderObjectPropertyProperty() {
        return wonderObjectProperty;
    }

    public void setWonderObjectProperty(Wonder wonderObjectProperty) {
        this.wonderObjectProperty.set(wonderObjectProperty);
    }
}
