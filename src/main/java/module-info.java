module fr.isep.javarchitects {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens fr.isep.javarchitects to javafx.fxml;
    exports fr.isep.javarchitects;
    exports Application;
    opens Application to javafx.fxml;
}