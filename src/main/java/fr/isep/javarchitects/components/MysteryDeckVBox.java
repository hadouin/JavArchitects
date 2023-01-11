package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.Decks;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class MysteryDeckVBox extends VBox {
    private Decks mysteryDeck;

    public MysteryDeckVBox(Decks mysteryDeck){
        this.setSpacing(5);
        setCardDecks(mysteryDeck);
    }

    public void setCardDecks(Decks mysteryDeck) {
        this.mysteryDeck = mysteryDeck;
        update();
    }

    private void update() {
        if (this.mysteryDeck == null){
            return;
        }
        int nbCardsInDeck = this.mysteryDeck.listeCartes.size();
        this.getChildren().clear();
        //Create a card back

        Image image = new Image(getClass().getResourceAsStream("/images/cards/card-back/card-back-question.png"));
        ImageView imageView = new ImageView(image);


        if(nbCardsInDeck>0) {

            imageView.setFitWidth(imageView.getImage().getWidth() / 3);
            imageView.setPreserveRatio(true);
            this.getChildren().add(imageView);
            //Create a rounded button/label with count of cards in deck
            Circle circle = new Circle(10);
            circle.setFill(Color.web("#FFFFFF"));
            circle.setStrokeWidth(2);
            circle.setStroke(Color.DARKBLUE);
            Text text = new Text(String.valueOf(nbCardsInDeck));
            text.setBoundsType(TextBoundsType.VISUAL);
            StackPane stack = new StackPane();
            stack.getChildren().add(circle);
            stack.getChildren().add(text);
            this.getChildren().add(stack);
        }
        else {
            imageView.setImage(null);
            this.getChildren().add(imageView);
        }



        /*

        for (GameAction gameAction : gameActionList) {
            Button button = new Button(gameAction.name);
            button.setOnAction(e -> {
                gameAction.action.complete();
            });
            this.getChildren().add(button);
        }

         */
    }
}
