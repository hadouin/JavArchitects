package fr.isep.javarchitects.components;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NumberCircle extends StackPane {
    private int number;
    private Label numberLabel;
    private Circle circleBG;

    public NumberCircle(int number){
        circleBG = new Circle(10);
        circleBG.setFill(Color.web("#FFFFFF"));
        circleBG.setStrokeWidth(2);
        circleBG.setStroke(Color.DARKBLUE);

        this.number = number;

        numberLabel = new Label(String.valueOf(number));

        this.getChildren().addAll(circleBG,numberLabel);
    }

    public void setNumber(int number) {
        this.number = number;
        updateView();
    }

    private void updateView() {
        this.numberLabel.setText(String.valueOf(number));
    }
}
