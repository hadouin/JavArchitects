package fr.isep.javarchitects;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConcurrencyExample extends Application {

    private int count = 0;
    private final Text text = new Text(Integer.toString(count));

    private void incrementCount() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                count++;
                text.setText(Integer.toString(count));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFX App");

        ProgressBar progressBar = new ProgressBar(0);

        VBox vBox = new VBox(progressBar);
        vBox.getChildren().add(text);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double progress = 0;
                for(int i=0; i<10; i++){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    incrementCount();

                    progress += 0.1;
                    final double reportedProgress = progress;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar
                                    .setProgress(reportedProgress);
                        }
                    });
                }
            }
        });

        taskThread.start();
    }
}