package fr.isep.javarchitects.utils;

import javafx.scene.image.Image;

import java.awt.*;

public enum WonderImage {
    Alexandria("/images/wonder_alexandria.png"),
    Halicarnassus("/images/wonder_hallicarnas.png"),
    Ephesus("/images/wonder_artemis.png"),
    Olympia("/images/wonder_zeus.png"),
    Babylon("/images/wonder_babylon.png"),
    Rhodes("/images/wonder_rhodes.png"),
    Gizeh("/images/wonder_gizeh.png");
    private final SpriteSheet spriteSheet;

    WonderImage(String spritePath) {
        spriteSheet = new SpriteSheet(getClass().getResourceAsStream(spritePath), 6,2);
    }

    public Image getImage(WonderImageType wonderImageType){
        return spriteSheet.getImageFromOrdinal(wonderImageType.ordinal());
    }
}
