package fr.isep.javarchitects.Fenetres;

import fr.isep.javarchitects.model.Game;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GamePlayFieldHeaderArea {
    public HBox headerArea;
    public HBox conflictArea;
    public HBox middleArea;
    public HBox progressArea;

    public HBox getHeaderArea(){return this.headerArea;}

    public GamePlayFieldHeaderArea(Game game, VBox parent){
        this.headerArea = new HBox();
        this.conflictArea = createConflictArea(game);
        this.middleArea = createMiddleArea(game);
        this.progressArea = createProgressArea(game);
        this.headerArea.getChildren().add( conflictArea);
        this.headerArea.getChildren().add( middleArea);
        this.headerArea.getChildren().add( progressArea);
    }

    private HBox createConflictArea(Game game){
        HBox retValue = new HBox();
        int nbTokens = game.getGameController().getGameStateVisible().getMaxConflictTokens();
        for (int t=0; t<nbTokens;t++){
            ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens/token-conflict-peace.png")));
            // image1.setFitHeight(100);
            image1.setFitWidth(image1.getImage().getWidth()/3);
            image1.setPreserveRatio(true);
            image1.setSmooth(true);
            retValue.setMargin(image1, new Insets(2, 2, 2, 2));
            retValue.getChildren().add(image1);
        }
        return retValue;
    }

    private HBox createMiddleArea(Game game){
        HBox retValue = new HBox();
        return retValue;
    }

    private HBox createProgressArea(Game game){
        HBox retValue = new HBox();
        return retValue;
    }
}
