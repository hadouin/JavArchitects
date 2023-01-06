package fr.isep.javarchitects.model;

import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import fr.isep.javarchitects.model.Joueur;

import java.util.ArrayList;

public class Partie {

    private int NbrJoueurs;
    private ArrayList<Joueur> joueurs;
    private int joueurActuelId = 0;
    private int nbrTour = 1;

    public Partie(int nbrJoueur, ArrayList<String> nomJoueur, FenetrePrincipale fp) {
        this.NbrJoueurs = nbrJoueur;
        joueurs = new ArrayList<>();
        for(int i = 0; i < nbrJoueur; i++) {
            joueurs.add(new Joueur(nomJoueur.get(i), i));
        }
    }
    public void demarerLaPartie(){};

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Joueur getJoueurActuel() {
        return joueurs.get(joueurActuelId);
    }

    public void setJoueurSuivant() {
        joueurActuelId++;
        if (joueurActuelId >= this.NbrJoueurs) {
            this.joueurActuelId = 0;
            this.nbrTour++;
        }
    }
}
