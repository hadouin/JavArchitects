package fr.isep.javarchitects.controllers;

import fr.isep.javarchitects.core.Game;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MenuController {

    ArrayList<String> playerNames = new ArrayList<String>();

    @FXML
    public void playButtonClick(ActionEvent e) {
        for (int i = 0; i < 7; i++) {
            TextField textFieldPlayerN = (TextField) (((Button) (e.getTarget())).getScene().getRoot().lookup("#P" + (i + 1)));
            if (textFieldPlayerN != null && !textFieldPlayerN.getText().trim().isEmpty()) {
                playerNames.add(textFieldPlayerN.getText());
            }
        }
        if (playerNames.size()<2){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut au moins 2 joueurs ...!\n\rRecommencez ou quittez.", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            openGameView();
            Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    private void openGameView() {
        Game game = new Game(playerNames.size(), playerNames);
        GameController gameController = new GameController(game);
    }

    public void cancelButtonClick(ActionEvent e)
    {
        Platform.exit();
        System.exit(0);
    }

}
