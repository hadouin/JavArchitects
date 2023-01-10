package fr.isep.javarchitects.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

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

    /**
     * @param xGrid column position in sprite sheet grid
     * @param yGrid row position in sprite sheet grid
     * @param xSize grid number of columns
     * @param ySize grid number of rows
     * @return the image at the given x,y position in the sprite sheet
     */
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

    /**
     * @param image buffered image to convert
     * @return return javaFX Image from bufferedImage
     */
    public static Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
    }

}
