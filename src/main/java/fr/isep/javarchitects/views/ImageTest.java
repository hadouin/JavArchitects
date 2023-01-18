package fr.isep.javarchitects.views;

import fr.isep.javarchitects.utils.WonderImage;
import fr.isep.javarchitects.utils.WonderImageType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ImageView front1 = new ImageView(WonderImage.Alexandria.getImage(WonderImageType.FRONT_1));
        front1.setFitWidth(200);
        front1.setPreserveRatio(true);
        ImageView front2 = new ImageView(WonderImage.Alexandria.getImage(WonderImageType.FRONT_2));
        front2.setFitWidth(200);
        front2.setPreserveRatio(true);
        ImageView front3 = new ImageView(WonderImage.Alexandria.getImage(WonderImageType.FRONT_3));
        front3.setFitWidth(200);
        front3.setPreserveRatio(true);
        ImageView front4 = new ImageView(WonderImage.Alexandria.getImage(WonderImageType.FRONT_4));
        front4.setFitWidth(200);
        front4.setPreserveRatio(true);
        StackPane root = new StackPane();
        root.getChildren().addAll(front1, front2, front3, front4);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
