package fr.isep.javarchitects.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;

public enum Icons {
    WOOD(0,0),
    STONE(1, 0);

    public final Sprite ICON_SPRITE = new Sprite(getClass().getResourceAsStream("/images/icons.png"));
    private static final int COLUMNS = 10;
    private static final int ROWS = 2;
    public final Image image;

    Icons(int x, int y) {
        this.image = convertToFxImage(this.ICON_SPRITE.getSpriteAutoSize(x,y, COLUMNS, ROWS));
    }

    private Image convertToFxImage(BufferedImage image) {
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
