package Fenetres;

import JeuDePlateau.Joueur;
import JeuDePlateau.Partie;
import fr.isep.javarchitects.Decks;
import fr.isep.javarchitects.Wonder;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.skin.SliderSkin;
import javafx.scene.layout.AnchorPane;
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
    private Partie partie;

    public FenetrePrincipale(Stage primaryStage) {
        this.mainStage = primaryStage;
        mainPane = new StackPane();
        Scene scene = new Scene(mainPane);

        mainStage.setScene(scene);
        mainStage.setTitle("Seven Wonders Architect");
        Fp.getMainStage().show();
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
            J.setSelfDeck(decks.remove(J.getWonder().getID()));
        }
    }

    public void setPartie(int nbrJoueur, ArrayList<String> nomJoueurs) {
        partie = new Partie(nbrJoueur, nomJoueurs, this);

        for(int i = 0; i < nbrJoueur; i++) {
            setWonder(partie.getJoueurs());
            setDecks(partie.getJoueurs());

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
