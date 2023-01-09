package fr.isep.javarchitects.Fenetres;

import fr.isep.javarchitects.model.Player;
import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.Decks;
import fr.isep.javarchitects.model.Wonder;
import fr.isep.javarchitects.model.ProgressToken;
import fr.isep.javarchitects.model.ProgressTokens;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GamePlayFieldWindow {

    private Stage mainStage;
    private Stage menuStage;
    private AnchorPane mainPane;
    private GamePlayFieldWindow gamePlayField ;
    private FenetreDemarage fd = new FenetreDemarage(this);
    private Game game;
    public static final int HEIGHT = 800;
    public static final int WIDTH = 1000;
    private ArrayList<ImageView> ImagesDecks;
    private ArrayList<ImageView> imageProgressToken;
    private HBox jetonsGuerre;
    private int compteurCorne = 0;
    private VBox jetonsProgres;
    private Label descLab;



    public GamePlayFieldWindow(Stage primaryStage) {
        this.mainStage = primaryStage;
        mainPane = new AnchorPane();
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage.setScene(scene);
        mainStage.setTitle("Seven Wonders Architect");

        fd.getStage().show();
    };

    public GamePlayFieldWindow() {};

    /**
     * Fonction qui va assigner à chaque joueur de listeJoueurs merveille.
     * De manière random
     * @param listePlayers
     */
    public void setWonder(ArrayList<Player> listePlayers) {
        Random R = new Random();
        ArrayList<Wonder> listeWonder = new ArrayList<>();
        for (Wonder W : Wonder.values()) {
            listeWonder.add(W);
        }

        for (Player J : listePlayers) {
            int C = R.nextInt(listeWonder.size());
            J.setWonder(listeWonder.remove(C));
        }
    }

    public void setDecks(ArrayList<Player> listePlayers) {

        // fonction qui va assigner à chaque joueur deux decks : son propre deck, positionné à sa droite, et le deck
        // de son voisin de gauche

        ArrayList<Decks> decks = new ArrayList<>();
        for (Decks D : Decks.values()) {
            decks.add(D);
        }

        for (Player J : listePlayers) {
            J.setSelfDeck(decks.get(J.getWonder().getID()));
        }
        for (int i = listePlayers.size() - 1; i >= 0 ; i--) {
            Player player = listePlayers.get(i);
            if(i > 0) {
                player.setRightDeck(listePlayers.get(i - 1).getSelfDeck());
            }
            else {
                player.setRightDeck(listePlayers.get(listePlayers.size() - 1).getSelfDeck());
            }
        }
    }

    public void setRightDecks(ArrayList<Player> listePlayers) {

    }

    public void setPartie(int nbPlayers, ArrayList<String> playerNames) {
        game = new Game(nbPlayers, playerNames, this);
        VBox overallArea = new VBox();
        GamePlayFieldHeaderArea headerArea = new GamePlayFieldHeaderArea(this.game, overallArea, WIDTH, HEIGHT);
        //VBox wonderArea = new WonderArea(overallArea);


        overallArea.getChildren().add(headerArea.getHeaderArea());
        mainPane.getChildren().add(overallArea);

        for(int i = 0; i < nbPlayers; i++) {
            //mainPane.getChildren().add(setBabylon());
        }
    }

    public void creationFenetrePrincipale(Stage menuStage, GamePlayFieldWindow gamePlayField) {
        this.menuStage = menuStage;
        this.gamePlayField = gamePlayField;
        //createBackgroud();
        //gameLoop();

        mainStage.show();
        this.menuStage.close();

    }

    public VBox setAlexandrie() {
        VBox wonder = new VBox();
        Image I = new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-1.png"));
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-1.png")));
        image1.setFitWidth(image1.getImage().getWidth()/3);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-4.png")));
        image2.setFitWidth(image2.getImage().getWidth()/3);
        image2.setPreserveRatio(true);

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-2.png")));
        image3.setFitWidth(image3.getImage().getWidth()/3);
        image3.setPreserveRatio(true);

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-3.png")));
        image4.setFitWidth(image4.getImage().getWidth()/3);
        image4.setPreserveRatio(true);

        ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-6.png")));
        image5.setFitWidth(image5.getImage().getWidth()/3);
        image5.setPreserveRatio(true);




        VBox.setMargin(image2, new Insets(0, 0, 0., 60));
        VBox.setMargin(image3, new Insets(0, 0, 0., 57));
        VBox.setMargin(image4, new Insets(0, 0, 0., 75));
        VBox.setMargin(image5, new Insets(0, 0, 0., 85));

        wonder.getChildren().addAll(image5, image4,  image3, image2, image1);
        //((ImageView) wonder.getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-front-alexandrie-6.png")));

        return wonder;
    }

    public VBox setBabylon() {

        VBox wonder = new VBox();

        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/babylon/piece-back-babylon-1.png")));
        image1.setFitWidth(image1.getImage().getWidth()/3);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/babylon/piece-back-babylon-2.png")));
        image2.setFitWidth(image2.getImage().getWidth()/3);
        image2.setPreserveRatio(true);
        image2.setSmooth(true);

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/babylon/piece-back-babylon-4.png")));
        image3.setFitWidth(image3.getImage().getWidth()/3);
        image3.setPreserveRatio(true);
        image3.setSmooth(true);

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/babylon/piece-back-babylon-5.png")));
        image4.setFitWidth(image4.getImage().getWidth()/3);
        image4.setPreserveRatio(true);
        image4.setSmooth(true);

        ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/babylon/piece-back-babylon-6.png")));
        image5.setFitWidth(image5.getImage().getWidth()/3);
        image5.setPreserveRatio(true);
        image5.setSmooth(true);

        VBox.setMargin(image2, new Insets(0, 0, 0., 5));
        VBox.setMargin(image3, new Insets(0, 0, 0., 20));
        VBox.setMargin(image4, new Insets(0, 0, 0., 30));
        VBox.setMargin(image5, new Insets(40, 0, -75., 110));

        wonder.getChildren().addAll(image5, image4,  image3, image2, image1);
        //((ImageView) wonder.getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-front-alexandrie-6.png")));

        return wonder;
    }

    public VBox setEphese() {
        VBox wonder = new VBox();
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/ephese/piece-back-ephese-1.png")));
        // image1.setFitHeight(100);
        image1.setFitWidth(image1.getImage().getWidth()/3);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/ephese/piece-back-ephese-3.png")));
        image2.setFitWidth(image2.getImage().getWidth()/3);
        image2.setPreserveRatio(true);

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/ephese/piece-back-ephese-4.png")));
        image3.setFitWidth(image3.getImage().getWidth()/3);
        image3.setPreserveRatio(true);

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/ephese/piece-back-ephese-2.png")));
        image4.setFitWidth(image4.getImage().getWidth()/3);
        image4.setPreserveRatio(true);

        ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/ephese/piece-back-ephese-6.png")));
        image5.setFitWidth(image5.getImage().getWidth()/3);
        image5.setPreserveRatio(true);




        VBox.setMargin(image2, new Insets(0, 0, 0., 20));
        VBox.setMargin(image3, new Insets(0, 0, -105., 85));
        VBox.setMargin(image4, new Insets(0, 0, -105., 150));
        VBox.setMargin(image5, new Insets(0, 0, -2., 10));

        wonder.getChildren().addAll(image5, image4,  image3, image2, image1);
        //((ImageView) wonder.getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-front-alexandrie-6.png")));

        return wonder;
    }

    public VBox setGiseh() {
        VBox wonder = new VBox();
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/giseh/piece-back-giseh-1.png")));
        // image1.setFitHeight(100);
        image1.setFitWidth(image1.getImage().getWidth()/3);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/giseh/piece-back-giseh-2.png")));
        image2.setFitWidth(image2.getImage().getWidth()/3);
        image2.setPreserveRatio(true);

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/giseh/piece-back-giseh-3.png")));
        image3.setFitWidth(image3.getImage().getWidth()/3);
        image3.setPreserveRatio(true);

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/giseh/piece-back-giseh-4.png")));
        image4.setFitWidth(image4.getImage().getWidth()/3);
        image4.setPreserveRatio(true);

        ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/giseh/piece-back-giseh-5.png")));
        image5.setFitWidth(image5.getImage().getWidth()/3);
        image5.setPreserveRatio(true);




        VBox.setMargin(image2, new Insets(0, 0, 0., 20));
        VBox.setMargin(image3, new Insets(0, 0, 0., 42));
        VBox.setMargin(image4, new Insets(0, 0, 0., 63));
        VBox.setMargin(image5, new Insets(0, 0, 0., 84.5));

        wonder.getChildren().addAll(image5, image4,  image3, image2, image1);
        //((ImageView) wonder.getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-front-alexandrie-6.png")));

        return wonder;
    }

    public VBox setHalicarnasse() {
        VBox wonder = new VBox();
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/halicarnasse/piece-back-halicarnasse-1.png")));
        image1.setFitWidth(image1.getImage().getWidth()/3);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/halicarnasse/piece-back-halicarnasse-2bis.png")));
        image2.setFitWidth(image2.getImage().getWidth()/3);
        image2.setPreserveRatio(true);

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/halicarnasse/piece-back-halicarnasse-4.png")));
        image3.setFitWidth(image3.getImage().getWidth()/3);
        image3.setPreserveRatio(true);

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/halicarnasse/piece-back-halicarnasse-3.png")));
        image4.setFitWidth(image4.getImage().getWidth()/3);
        image4.setPreserveRatio(true);

        ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/halicarnasse/piece-back-halicarnasse-5.png")));
        image5.setFitWidth(image5.getImage().getWidth()/3);
        image5.setPreserveRatio(true);




        VBox.setMargin(image2, new Insets(0, 0, 0., 5));
        VBox.setMargin(image3, new Insets(0, 0, -11, 5));
        VBox.setMargin(image4, new Insets(0, 0, -77, 85));
        VBox.setMargin(image5, new Insets(0, 0, -3., 25));

        wonder.getChildren().addAll(image5, image4,  image3, image2, image1);
        //((ImageView) wonder.getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-front-alexandrie-6.png")));

        return wonder;
    }

    public VBox setRhodes() {
        VBox wonder = new VBox();
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/rhodes/piece-back-rhodes-1bis.png")));
        // image1.setFitHeight(100);
        image1.setFitWidth(image1.getImage().getWidth()/3);
        image1.setPreserveRatio(true);
        image1.setSmooth(true);

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/rhodes/piece-back-rhodes-2bis.png")));
        image2.setFitWidth(image2.getImage().getWidth()/3);
        image2.setPreserveRatio(true);

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/rhodes/piece-back-rhodes-3.png")));
        image3.setFitWidth(image3.getImage().getWidth()/3);
        image3.setPreserveRatio(true);

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/rhodes/piece-back-rhodes-4.png")));
        image4.setFitWidth(image4.getImage().getWidth()/3);
        image4.setPreserveRatio(true);

        ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/rhodes/piece-back-rhodes-5.png")));
        image5.setFitWidth(image5.getImage().getWidth()/3);
        image5.setPreserveRatio(true);




        VBox.setMargin(image2, new Insets(0, 0, -47., 85));
        VBox.setMargin(image3, new Insets(0, 0, 0, 25));
        VBox.setMargin(image4, new Insets(0, 0, 0., 18));
        VBox.setMargin(image5, new Insets(0, 0, -3., 24));

        wonder.getChildren().addAll(image5, image4,  image3, image2, image1);
        //((ImageView) wonder.getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-front-alexandrie-6.png")));

        return wonder;
    }

    public VBox setProgressToken() {
        imageProgressToken = new ArrayList<>();
        VBox vboxToken = new VBox();
        HBox H = new HBox();

        List<ProgressToken> listToken = ProgressTokens.TOKENS;
        ArrayList<ProgressToken> L = new ArrayList<>();
        for(ProgressToken P : listToken) {
            L.add(P);
        }
        Collections.shuffle(L);
        ImageView imageIP = new ImageView(new Image(getClass().getResourceAsStream("/images/tokens-progress/back/token-back.png")));
        imageIP.setFitWidth(imageIP.getImage().getWidth() / 3);
        imageIP.setPreserveRatio(true);
        H.getChildren().add(imageIP);
        for(int i = 0; i < 3; i++) {

            imageProgressToken.add(new ImageView(new Image(getClass().getResourceAsStream(L.get(i).imageResource))));
            ImageView imageT = imageProgressToken.get(i);
            int finalI = i;
            imageT.setOnMouseEntered(event -> {
                descLab.setText(L.get(finalI).effectDescription);
            });

            imageT.setOnMouseExited(event1 -> {
                descLab.setText("");
            });

            imageT.setFitWidth(imageT.getImage().getWidth() / 3);
            imageT.setPreserveRatio(true);


            H.getChildren().add(imageT);
        }
        vboxToken.getChildren().add(H);

        return vboxToken;
    }

    // -------------------------------------------------------

    public Stage getMainStage() {
        return mainStage;
    }
}
