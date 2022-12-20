module fr.isep.javarchitects {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.isep.javarchitects to javafx.fxml;
    exports fr.isep.javarchitects;
}