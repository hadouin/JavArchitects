package Fenetres;

import JeuDePlateau.Joueur;
import JeuDePlateau.Partie;
import fr.isep.javarchitects.Decks;
import fr.isep.javarchitects.Wonder;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class FenetrePrincipale {

    private Stage mainStage;
    private Stage menuStage;
    private StackPane mainPane;
    private ArrayList <Label> l_Joueurs = new ArrayList<Label>();
    private ArrayList <Joueur> ListeJoueurs = new ArrayList<Joueur>();
    private FenetrePrincipale Fp;
    private FenetreDemarage fd = new FenetreDemarage(this);
    private Partie partie;
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1000;

    public FenetrePrincipale(Stage primaryStage) {
        this.mainStage = primaryStage;
        mainPane = new StackPane();
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.setTitle("Seven Wonders Architect");

        fd.getStage().show();
        //Fp.getMainStage().show();
    };

    public FenetrePrincipale() {
    };

    public void setWonder(ArrayList<Joueur> listeJoueurs) {
        Random R = new Random();
        ArrayList<Wonder> listeWonder = new ArrayList<>();
        for (Wonder W : Wonder.values()) {
            listeWonder.add(W);
        }

        for (Joueur J : listeJoueurs) {
            int C = R.nextInt(listeWonder.size());
            J.setWonder(listeWonder.remove(C));
        }
    }
    
    public void setDecks(ArrayList<Joueur> listeJoueurs) {
        ArrayList<Decks> decks = new ArrayList<>();
        for (Decks D : Decks.values()) {
            decks.add(D);
        }

        for (Joueur J : listeJoueurs) {
            J.setSelfDeck(decks.get(J.getWonder().getID()));
        }

        for (int i = listeJoueurs.size() - 1; i >= 0 ; i--) {
            Joueur joueur = listeJoueurs.get(i);
            if(i > 0) {
                joueur.setRightDeck(listeJoueurs.get(i - 1).getSelfDeck());
            }
            else {
                joueur.setRightDeck(listeJoueurs.get(listeJoueurs.size() - 1).getSelfDeck());
            }
        }
    }

    public void setRightDecks(ArrayList<Joueur> listeJoueurs) {

    }

    public void setPartie(int nbrJoueur, ArrayList<String> nomJoueurs) {
        partie = new Partie(nbrJoueur, nomJoueurs, this);
        setWonder(partie.getJoueurs());
        setDecks(partie.getJoueurs());
        VBox Alexandrie = setHalicarnasse();
        mainPane.getChildren().add(Alexandrie);
        for(int i = 0; i < nbrJoueur; i++) {

            Label labelJoueur = new Label(partie.getJoueurs().get(i).getNom());

            l_Joueurs.add(labelJoueur);

            mainPane.getChildren().add(l_Joueurs.get(i));
        }
    }

    public void creationFenetrePrincipale(Stage menuStage, FenetrePrincipale Fp) {
        this.menuStage = menuStage;
        this.Fp = Fp;
        //createBackgroud();
        //gameLoop();

        mainStage.show();
        this.menuStage.close();

    }

    public VBox setAlexandrie() {
        VBox wonder = new VBox();
        Image I = new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-1.png"));
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/wonders/alexandrie/piece-back-alexandrie-1.png")));
        // image1.setFitHeight(100);
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
    // -------------------------------------------------------

    public Stage getMainStage() {
        return mainStage;
    }
}
