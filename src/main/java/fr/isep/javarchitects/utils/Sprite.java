package fr.isep.javarchitects.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage spriteSheet;
    private int xTileSize;
    private int yTileSize;
    InputStream inputStream;

    public Sprite(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public BufferedImage loadSprite(InputStream file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public BufferedImage getSpriteAutoSize(int xGrid, int yGrid, int xSize, int ySize) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite(inputStream);
        }
        if (spriteSheet != null) {
            xTileSize = spriteSheet.getWidth() / xSize;
            yTileSize = spriteSheet.getHeight() / ySize;
        }

        return spriteSheet.getSubimage(xGrid * xTileSize, yGrid * yTileSize, xTileSize, yTileSize);
    }

}
