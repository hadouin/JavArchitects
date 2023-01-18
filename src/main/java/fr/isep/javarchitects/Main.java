package fr.isep.javarchitects;

import fr.isep.javarchitects.components.SplashScreen;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Application to be launch by default, nothing yet still testing
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.show();
        splashScreen.startLoading();
    }

}



