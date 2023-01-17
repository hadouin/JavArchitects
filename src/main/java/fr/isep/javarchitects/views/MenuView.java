package fr.isep.javarchitects.views;


import fr.isep.javarchitects.controllers.MenuController;
import fr.isep.javarchitects.utils.IVoidComplete;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuView extends Stage {
    MenuController menuControllerInstance;

    public MenuController getMenuControllerInstance() {
        return menuControllerInstance;
    }

    public MenuView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MenuView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        menuControllerInstance = loader.getController();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icons/selectPlayers.png")));
        stage.show();
    }
}
