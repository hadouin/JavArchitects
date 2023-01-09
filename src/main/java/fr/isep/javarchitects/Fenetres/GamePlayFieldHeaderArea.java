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
    Game game;
    int width;
    int height;

    public HBox getHeaderArea(){return this.headerArea;}

    public GamePlayFieldHeaderArea(Game game, VBox parent, int width, int height){
        this.game = game;
        this.width = width;
        this.height = height;
        this.headerArea = new HBox();
        this.conflictArea = createConflictArea(game);
        this.middleArea = createMiddleArea(game);
        this.progressArea = createProgressArea(game);

        double areaWidth = this.width/3;
        conflictArea.setPrefWidth(areaWidth);
        middleArea.setPrefWidth(areaWidth);
        progressArea.setPrefWidth(areaWidth);

        this.headerArea.getChildren().add( conflictArea);
        this.headerArea.getChildren().add( middleArea);
        this.headerArea.getChildren().add( progressArea);
    }

    private HBox createConflictArea(Game game){
        HBox retValue = new HBox();
        int nbTokens = game.getGameController().getGameStateVisible().getMaxConflictTokens();
        for (int tok=0; tok<nbTokens;tok++){
            ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens/token-conflict-peace.png")));
            // image1.setFitHeight(100);s
            image1.setFitWidth(image1.getImage().getWidth()/2);
            image1.setPreserveRatio(true);
            image1.setSmooth(true);
            retValue.setMargin(image1, new Insets(2, 2, 2, 2));
            retValue.getChildren().add(image1);
        }
        return retValue;
    }

    private HBox createMiddleArea(Game game){
        HBox retValue = new HBox();
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/cards/card-back/card-back-question.png")));
        image1.setFitHeight(150);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);
        retValue.setMargin(image1, new Insets(2, 2, 2, 2));

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens/token-cat.png")));
        image2.setFitHeight(150);
        image2.setPreserveRatio(true);
        image2.setSmooth(true);
        retValue.setMargin(image2, new Insets(2, 2, 2, 2));

        retValue.getChildren().add( image1);
        retValue.getChildren().add( image2);
        return retValue;
    }

    private HBox createProgressArea(Game game){
        HBox retValue = new HBox();

        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens-progress/back/token-back.png")));
        image1.setFitWidth(image1.getImage().getWidth()/2);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);
        retValue.setMargin(image1, new Insets(2, 2, 2, 2));

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens-progress/token-culture.png")));
        image2.setFitWidth(image2.getImage().getWidth()/2);
        image2.setPreserveRatio(true);
        image2.setSmooth(true);
        retValue.setMargin(image2, new Insets(2, 2, 2, 2));

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens-progress/token-tactic.png")));
        image3.setFitWidth(image3.getImage().getWidth()/2);
        image3.setPreserveRatio(true);
        image3.setSmooth(true);
        retValue.setMargin(image3, new Insets(2, 2, 2, 2));

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens-progress/token-urbanism.png")));
        image4.setFitWidth(image4.getImage().getWidth()/2);
        image4.setPreserveRatio(true);
        image4.setSmooth(true);
        retValue.setMargin(image4, new Insets(2, 2, 2, 2));

        retValue.getChildren().add( image1);
        retValue.getChildren().add( image2);
        retValue.getChildren().add( image3);
        retValue.getChildren().add( image4);

        return retValue;
    }

    public void updateConflictTokenImages(){
        int nbTokens = this.game.getGameController().getGameStateVisible().getMaxConflictTokens();
        for (int tok=0; tok<nbTokens;tok++){
            ImageView img = (ImageView) this.conflictArea.getChildren().get(tok);
            img.setImage(new Image(this.game.getGameController().getGameStateVisible().getConflictTokenImagePath(tok)));
        }
    }

    public void updateMiddleTokenImages(){
        ImageView img = (ImageView) this.conflictArea.getChildren().get(1);
        if (this.game.getPlayerWithCat() > -1){
            img.setImage(new Image(getClass().getResourceAsStream("/images/others/empty.png")));
        }
    else {
            img.setImage(new Image(getClass().getResourceAsStream("/images/tokens/token-cat.png")));
        }
    }

    public void updateProgressTokenImages(){

    }

}
