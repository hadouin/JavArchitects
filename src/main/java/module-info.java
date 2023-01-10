module fr.isep.javarchitects {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;


    opens fr.isep.javarchitects to javafx.fxml;
    exports fr.isep.javarchitects;
    exports fr.isep.javarchitects.model;
    opens fr.isep.javarchitects.model to javafx.fxml;
    exports fr.isep.javarchitects.views;
    opens fr.isep.javarchitects.views to javafx.fxml;
    exports fr.isep.javarchitects.utils;
    opens fr.isep.javarchitects.utils to javafx.fxml;
    exports fr.isep.javarchitects.controllers;
    opens fr.isep.javarchitects.controllers to javafx.fxml;
}