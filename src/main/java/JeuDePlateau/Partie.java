package JeuDePlateau;

import Fenetres.FenetrePrincipale;

import java.util.ArrayList;

public class Partie {

    private int NbrJoueurs;
    private ArrayList<Joueur> joueurs;

    public Partie(int nbrJoueur, ArrayList<String> nomJoueur, FenetrePrincipale fp) {
        for(int i = 0; i < nbrJoueur; i++) {
            joueurs.add(new Joueur(nomJoueur.get(i), i));
        }
    }
    public void demarerLaPartie(){};

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}
