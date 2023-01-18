package fr.isep.javarchitects.views;

import fr.isep.javarchitects.components.*;
import fr.isep.javarchitects.model.GameStateVisible;
import fr.isep.javarchitects.model.PlayerVisible;
import fr.isep.javarchitects.utils.Subscriber;
import fr.isep.javarchitects.model.WonderFactory;
import fr.isep.javarchitects.utils.Icons;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Iterator;

/**
 * GameUI is the main component of ui view for the game.
 * It is a stage that will subscribe to the controller/publisher changes
 */
public class GameUI extends Stage implements Subscriber {
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1000;

    private GameStateVisible gameStateVisible;
    private Pane rootPane;
    private Scene mainScene;
    private ProgressTokenPane progressTokenView;
    private ConflictTokensHBox conflictTokensHBox;
    private ChoiceDisplayHBox choiceDisplayHBox;
    private final Image CAT_IMAGE = new Image(getClass().getResourceAsStream("/images/tokens/token-cat.png"));
    private ImageView catImageView;
    private VBox playersVBOX;


    @Override
    public void update(GameStateVisible gameStateVisible) {
        this.gameStateVisible = gameStateVisible;
        updateGame();
    }

    private void updateGame() {
        conflictTokensHBox.setConflictTokenList(gameStateVisible.conflictTokens);
        progressTokenView.setVisibleTokens(gameStateVisible.visibleProgressTokens);

        choiceDisplayHBox.setGameActionList(gameStateVisible.gameActionList);

        if (gameStateVisible.getCatOwner(gameStateVisible.players) != null){
            catImageView.setImage(null);
        } else {
            catImageView.setImage(CAT_IMAGE);
        }

        // update players
        Iterator<PlayerVisible> iterator = gameStateVisible.players.iterator();
        for (Node node : playersVBOX.getChildren()) {
            if (node instanceof PlayerView playerView) {
                if (iterator.hasNext()) {
                    playerView.setPlayer(iterator.next());
                } else {
                    break;
                }
            }
        }
    }

    public String getWindowTitle(){
        String ret = "JavArchitects ";
        int nbPlayers = this.gameStateVisible.players.size();
        ret+= nbPlayers+" joueurs";
        return ret;
    }

    public GameUI(GameStateVisible gameStateVisible){
        this.gameStateVisible = gameStateVisible;
        this.rootPane = new AnchorPane();
        this.mainScene = new Scene(rootPane, WIDTH, HEIGHT);
        this.setTitle(getWindowTitle());
        this.setScene(mainScene);
        Stage stage = (Stage) this.mainScene.getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icons/appIcon.png")));
        setupGame();
    }

    private void setupGame(){
        progressTokenView = new ProgressTokenPane(gameStateVisible.visibleProgressTokens);
        AnchorPane.setRightAnchor(progressTokenView, 2.);
        rootPane.getChildren().add(progressTokenView);

        conflictTokensHBox = new ConflictTokensHBox(gameStateVisible.conflictTokens);
        AnchorPane.setLeftAnchor(conflictTokensHBox, 2.);
        rootPane.getChildren().add(conflictTokensHBox);

        choiceDisplayHBox = new ChoiceDisplayHBox(null);
        AnchorPane.setLeftAnchor(choiceDisplayHBox, 100.);
        AnchorPane.setBottomAnchor(choiceDisplayHBox, 0.);
        rootPane.getChildren().add(choiceDisplayHBox);

        catImageView = new ImageView(CAT_IMAGE);
        catImageView.setFitWidth(catImageView.getImage().getWidth()/3);
        catImageView.setPreserveRatio(true);
        AnchorPane.setLeftAnchor(catImageView, 500.);
        rootPane.getChildren().add(catImageView);

        playersVBOX = new VBox();
        playersVBOX.setAlignment(Pos.TOP_CENTER);
        AnchorPane.setTopAnchor(playersVBOX, 0.);
        AnchorPane.setBottomAnchor(playersVBOX, 0.);
        AnchorPane.setLeftAnchor(playersVBOX, 0.);
        AnchorPane.setRightAnchor(playersVBOX, 0.);
        for (PlayerVisible player :
                gameStateVisible.players) {
            playersVBOX.getChildren().add(new PlayerView(player));
        }
        rootPane.getChildren().add(playersVBOX);
    }

}
