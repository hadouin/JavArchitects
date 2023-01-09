module fr.isep.javarchitects {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;


    opens fr.isep.javarchitects to javafx.fxml;
    exports fr.isep.javarchitects;
    exports fr.isep.javarchitects.model;
    opens fr.isep.javarchitects.model to javafx.fxml;
    exports fr.isep.javarchitects.Views;
    opens fr.isep.javarchitects.Views to javafx.fxml;
}