package fr.isep.javarchitects.utils.images;

import javafx.scene.image.Image;

public enum CardImage {
    BACK_CENTER,
    BACK_RHODES,
    BACK_BABYLON,
    BACK_HALICARNASSUS,
    BACK_ALEXANDRIA,
    BACK_GIZEH,
    BACK_OLYMPIA,
    BACK_EPHESUS,

    WOOD,
    STONE,
    CLAY,
    PAPER,
    GLASS,
    GOLD,
    VP_CAT,
    VP,

    WAR,
    WAR_1,
    WAR_2,
    MATH,
    MECH,
    LAW;
    public final SpriteSheet CARD_SHEET = new SpriteSheet(getClass().getResourceAsStream("/images/cards.png"), 8,3);
    public final Image image;

    CardImage() {
        this.image = CARD_SHEET.getImageFromOrdinal(this.ordinal());
    }
}
