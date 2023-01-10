package fr.isep.javarchitects.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;

public enum Icons {
    WOOD(0,0),
    STONE(1, 0),
    CLAY(2,0),
    PAPER(3,0),
    GLASS(4,0),
    COIN(5,0),
    VP_2(6,0),
    VP_3(7,0),
    VP(8,0),
    SHIELD_HORN(0,1),
    SHIELD_NUMBER(1,1),
    SHIELD(2,1),
    ARCHITECT(3,1),
    MECHANIC(4,1),
    LAW(5,1),
    BATTLE_TOKEN_3(6,1),
    CONFLICT_WAR(7,1),
    BATTLE_TOKEN(8,1),
    CONFLICT_PEACE(9,1);


    public final Sprite ICON_SPRITE = new Sprite(getClass().getResourceAsStream("/images/icons.png"));
    private static final int COLUMNS = 10;
    private static final int ROWS = 2;
    public final Image image;

    Icons(int x, int y) {
        this.image = Sprite.convertToFxImage(this.ICON_SPRITE.getSpriteAutoSize(x,y, COLUMNS, ROWS));
    }


}
