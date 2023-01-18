package fr.isep.javarchitects.utils;

import javafx.scene.image.Image;

import java.io.InputStream;

public class SpriteSheet {
    private Sprite sprite;
    private int columns;
    private int rows;

    SpriteSheet(Sprite sprite, int columns, int rows){
        this.sprite = sprite;
        this.columns = columns;
        this.rows = rows;
    }

    SpriteSheet(InputStream spriteStream, int columns, int rows){
        this.sprite = new Sprite(spriteStream);
        this.columns = columns;
        this.rows = rows;
    }

    public Image getImageFromOrdinal(int ordinal) {
        int x = ordinal % columns;
        int y = ordinal / rows;
        return Sprite.convertToFxImage(sprite.getSpriteAutoSize(x,y, columns, rows));
    };

}
