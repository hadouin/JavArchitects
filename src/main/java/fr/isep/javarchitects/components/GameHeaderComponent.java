package fr.isep.javarchitects.components;

import fr.isep.javarchitects.model.ConflictToken;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.ProgressToken;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class GameHeaderComponent extends HBox {
    GameModel gameModel;

    public GameHeaderComponent(){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10.);
    }

    public void initGameModel(GameModel gameModel){
        if (this.gameModel != null ){
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.gameModel = gameModel;

        //set conflict
        ConflictTokensHBox conflictTokensHBox = new ConflictTokensHBox(gameModel.getConflictTokens());
        this.getChildren().add(0, conflictTokensHBox);

        gameModel.getConflictTokens().addListener((ListChangeListener<ConflictToken>) change -> {
            conflictTokensHBox.setConflictTokenList(gameModel.getConflictTokens());
        });

        // set center deck
        DeckControl centerDeckDisplay = new DeckControl();
        centerDeckDisplay.imageObjectProperty().setValue(gameModel.centerDeckProperty().get().getCardBack().image);
        centerDeckDisplay.nbCardsProperty().bind(gameModel.centerDeckProperty().get().nbCardsProperty());
        centerDeckDisplay.setFitWidth(50);
        this.getChildren().add(1, centerDeckDisplay);

        // set progress token
        ProgressTokenPane progressTokenPane = new ProgressTokenPane(gameModel.getVisibleTokens());
        this.getChildren().add(2, progressTokenPane);

        gameModel.getProgressTokensList().addListener((ListChangeListener<ProgressToken>) change -> {
            progressTokenPane.setVisibleTokens(gameModel.getVisibleTokens());
        });

    }
}
