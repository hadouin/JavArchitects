module fr.isep.javarchitects {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;
    requires com.google.common;


    opens fr.isep.javarchitects to javafx.fxml;
    exports fr.isep.javarchitects;
    exports fr.isep.javarchitects.model;
    opens fr.isep.javarchitects.model to javafx.fxml;
    exports fr.isep.javarchitects.utils;
    opens fr.isep.javarchitects.utils to javafx.fxml;
    exports fr.isep.javarchitects.controllers;
    opens fr.isep.javarchitects.controllers to javafx.fxml;
    exports fr.isep.javarchitects.core;
    opens fr.isep.javarchitects.core to javafx.fxml;
    exports fr.isep.javarchitects.model.command;
    opens fr.isep.javarchitects.model.command to javafx.fxml;
    exports fr.isep.javarchitects.utils.images;
    opens fr.isep.javarchitects.utils.images to javafx.fxml;
    exports fr.isep.javarchitects.components;
    opens fr.isep.javarchitects.components to javafx.fxml;
    exports fr.isep.javarchitects.controls;
    opens fr.isep.javarchitects.controls to javafx.fxml;

}