package fr.isep.javarchitects.Application;

//import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import fr.isep.javarchitects.Fenetres.GamePlayFieldWindow;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;

/*

    Application to be launch by default, displaying a splashscreen then launching the PrincipalWindow / FenêtrePrincipale

*/

public class Main extends Application {
    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    private Stage mainStage;
    private static final int SPLASH_WIDTH = 1600;
    private static final int SPLASH_HEIGHT = 900;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void init() {
        String imageUrl = getClass().getResource("/images/others/7-wonders-second-edition-board-game-art.jpg").toString();
        ImageView splash = new ImageView(new Image(imageUrl));
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH);
        progressText = new Label("Chargement...");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setStyle(
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
        splashLayout.setEffect(new DropShadow());
    }

    @Override
    public void start(final Stage initStage) throws Exception {
        final Task<ObservableList<String>> taskToAchieve = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws InterruptedException {

                updateMessage("Chargement");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(150);
                    updateProgress(i + 1,10);

                }
                Thread.sleep(400);
                updateMessage("Ok");

                return null;
            }
        };

        showSplash(
                initStage,
                taskToAchieve,
                () -> showMainStage()
        );
        new Thread(taskToAchieve).start();
    }

    private void showMainStage() {
        mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("7 Wonders Architect");
        try {
            new GamePlayFieldWindow(mainStage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showSplash(
            final Stage initStage,
            Task<?> task,
            InitCompletionHandler initCompletionHandler
    ) {
        progressText.textProperty().bind(task.messageProperty());
        loadProgress.progressProperty().bind(task.progressProperty());
        task.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                loadProgress.progressProperty().unbind();
                loadProgress.setProgress(1);
                initStage.toFront();
                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
                fadeSplash.setFromValue(1.0);
                fadeSplash.setToValue(0.0);
                fadeSplash.setOnFinished(actionEvent -> initStage.hide());
                fadeSplash.play();

                initCompletionHandler.complete();
            } // todo add code to gracefully handle other task states.
        });

        Scene splashScene = new Scene(splashLayout, Color.TRANSPARENT);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.initStyle(StageStyle.TRANSPARENT);
        initStage.setAlwaysOnTop(true);
        initStage.show();
    }

    public interface InitCompletionHandler {
        void complete();
    }
}



