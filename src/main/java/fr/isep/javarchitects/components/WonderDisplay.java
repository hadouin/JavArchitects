package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.Wonder;
import fr.isep.javarchitects.model.WonderFragment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WonderDisplay extends VBox {
    Wonder wonder;

    public WonderDisplay(Wonder wonder){
        this.wonder = wonder;
        update();
    }

    private void update() {
        switch(wonder.getID()){
            case 0:
                setAlexandrie();
                break;
            case 1:
                setHalicarnasse();
                break;
            case 2:
                setEphese();
                break;
            case 4:
                setBabylone();
                break;
            case 5:
                setRhodes();
                break;
            case 6:
                setGiseh();
                break;
            default:
                setEphese();
                break;
        }
    }
    
    private void setAlexandrie(){
        this.setAlignment(Pos.CENTER);
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth()/3);
            imageView.setPreserveRatio(true);

            this.getChildren().add(imageView);
        }
    }

    private void setHalicarnasse() {
        this.setAlignment(Pos.CENTER);
        HBox floor2 = new HBox();
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth()/3);
            imageView.setPreserveRatio(true);
            if(fragment.getFloorNumber() == 2) {
                floor2.getChildren().add(imageView);
                HBox.setMargin(imageView, new Insets(0, 5, -12., 5));
                if(floor2.getChildren().size() == 2) {
                    this.getChildren().add(floor2);
                }
            }
            else {
                this.getChildren().add(imageView);
            }
        }
    }

    private void setEphese() {
        this.setAlignment(Pos.CENTER);
        HBox floor2 = new HBox();
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth()/3);
            imageView.setPreserveRatio(true);
            if(fragment.getFloorNumber() == 1) {
                floor2.getChildren().add(imageView);
                HBox.setMargin(imageView, new Insets(-2, 0, -2, 14));
                if(floor2.getChildren().size() == 3) {
                    this.getChildren().add(floor2);
                }
            }
            else {
                this.getChildren().add(imageView);
            }
        }
    }

    private void setBabylone() {
        this.setAlignment(Pos.CENTER);
        HBox floor2 = new HBox();
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth()/3);
            imageView.setPreserveRatio(true);
            if(fragment.getFloorNumber() == 3) {
                floor2.getChildren().add(imageView);
                HBox.setMargin(imageView, new Insets(0, 0, -2, 30));
                if(floor2.getChildren().size() == 2) {
                    this.getChildren().add(floor2);
                }
            }
            else {
                this.getChildren().add(imageView);
            }
        }
        HBox.setMargin(floor2.getChildren().get(1), new Insets(30,0,0,11));
    }

    private void setRhodes() {
        this.setAlignment(Pos.CENTER);
        HBox floor2 = new HBox();
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth()/3);
            imageView.setPreserveRatio(true);
            if(fragment.getFloorNumber() == 0) {
                floor2.getChildren().add(imageView);
                HBox.setMargin(imageView, new Insets(0, 0, 0, 10));
                if(floor2.getChildren().size() == 2) {
                    this.getChildren().add(floor2);
                }
            }
            else {
                this.getChildren().add(imageView);
            }
        }
    }

    private void setGiseh() {
        this.setAlignment(Pos.CENTER);
        for (int i = 1; i <= wonder.getWonderFragments().size(); i++) {
            WonderFragment fragment = this.wonder.getWonderFragments().get(wonder.getWonderFragments().size() - i);
            Image image = new Image(getClass().getResourceAsStream(fragment.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(imageView.getImage().getWidth() / 3);
            imageView.setPreserveRatio(true);
            this.getChildren().add(imageView);
        }
    }
}
