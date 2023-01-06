module fr.isep.javarchitects {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens fr.isep.javarchitects to javafx.fxml;
    exports fr.isep.javarchitects;
    exports fr.isep.javarchitects.Application;
    opens fr.isep.javarchitects.Application to javafx.fxml;
    exports fr.isep.javarchitects.model;
    opens fr.isep.javarchitects.model to javafx.fxml;
}