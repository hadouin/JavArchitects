package fr.isep.javarchitects.components;

import fr.isep.javarchitects.utils.IVoidComplete;
import javafx.animation.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScreen extends Stage {

    private VBox root = new VBox();
    private ImageView splashImage = new ImageView();
    private ProgressBar progressBar = new ProgressBar();
    private Label progressLabel = new Label();

    Transition mainTransition;
    private IVoidComplete doAfter;

    private int width = 730;
    private int height = 900;

    public SplashScreen(IVoidComplete doAfter) {
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        this.setX(bounds.getMinX() + bounds.getWidth() / 2 - width / 2);
        this.setY(bounds.getMinY() + bounds.getHeight() / 2 - height / 2);
        this.setAlwaysOnTop(true);
        this.initStyle(StageStyle.TRANSPARENT);
        this.setScene(new Scene(root, Color.TRANSPARENT));
        this.doAfter = doAfter;
        root.getChildren().addAll(splashImage, progressBar, progressLabel);
        styleControls();

        Timeline loadingTransition = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(progressBar.progressProperty(), 0)
                ),
                new KeyFrame(
                        Duration.seconds(2),
                        new KeyValue(progressBar.progressProperty(), 1)
                )
        );
        loadingTransition.setOnFinished(e -> {
            try {
                doAfter.complete();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), root);
        fadeSplash.setFromValue(1.0);
        fadeSplash.setToValue(0.0);
        fadeSplash.setOnFinished(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });

        SequentialTransition sequentialTransition = new SequentialTransition(loadingTransition, fadeSplash);
        this.mainTransition = sequentialTransition;
    }

    public void startLoading(){
        mainTransition.play();
    }

    private void styleControls() {
        styleRoot();
        styleImage();
        styleProgressBar();
        styleLabel();
    }

    private void styleLabel() {
        progressLabel.setText("Chargement...");
    }

    private void styleProgressBar() {
        progressBar.setPrefWidth(width);
    }

    private void styleRoot() {
        root.setStyle(
            "-fx-padding: 5; " +
                "-fx-background-color: cornsilk; " +
                "-fx-border-width:5; " +
                "-fx-border-color: " +
                "linear-gradient(" +
                "to bottom, " +
                "chocolate, " +
                "derive(chocolate, 50%)" +
                ");"
        );
        root.setEffect(new DropShadow());
    }

    private void styleImage() {
        String imageUrl = getClass().getResource("/images/others/7WA.jpg").toString();
        splashImage.setImage(new Image(imageUrl));
    }

}
