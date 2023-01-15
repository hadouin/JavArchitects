package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.utils.IVoidComplete;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController {

    private IVoidComplete doAfter;
    ArrayList<String> playerNames = new ArrayList<String>();

    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }

    public void setDoAfter(IVoidComplete doAfter) {
        this.doAfter = doAfter;
    }

    public void playButtonClick(ActionEvent e) throws IOException {
        for(int i=0; i<7; i++) {
            TextField textFieldPlayerN = (TextField) (((Button) (e.getTarget())).getScene().getRoot().lookup("#P"+(i+1)));
            if(textFieldPlayerN!=null && textFieldPlayerN.getText() != null && !textFieldPlayerN.getText().isEmpty())
                playerNames.add(textFieldPlayerN.getText());
        }
        if (playerNames.size()<2){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut au moins 2 joueurs ...!\n\rRecommencez ou quittez.", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            this.doAfter.complete();
        }
    }

    public void cancelButtonClick(ActionEvent e)
    {
        Platform.exit();
        System.exit(0);
    }

}
