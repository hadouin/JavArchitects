package Fenetres;

import JeuDePlateau.Joueur;
import JeuDePlateau.Partie;
import fr.isep.javarchitects.Decks;
import fr.isep.javarchitects.Wonder;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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

    public Stage getMainStage() {
        return mainStage;
    }
}
