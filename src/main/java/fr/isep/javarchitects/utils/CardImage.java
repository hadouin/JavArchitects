package fr.isep.javarchitects.utils;

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

    public final Sprite CARD_SPRITE = new Sprite(getClass().getResourceAsStream("/images/cards.png"));
    private static final int COLUMNS = 8;
    private static final int ROWS = 3;
    public int x;
    public int y;
    public final Image image;

    CardImage() {
        int x = ordinal() % COLUMNS;
        int y = ordinal() / COLUMNS;
        this.image = Sprite.convertToFxImage(CARD_SPRITE.getSpriteAutoSize(x,y, COLUMNS, ROWS));
    }
}
