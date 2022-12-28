package fr.isep.javarchitects;

import Fenetres.FenetrePrincipale;
import JeuDePlateau.Joueur;
import JeuDePlateau.Partie;
import org.junit.Test;

import java.util.*;

public class Tests {

    @Test
    public void test() {

        Decks deck = Decks.D_milieu;
        Decks deck2 = Decks.D_Halicarnasse;

        System.out.println(deck.getListeCartes().size());
        System.out.println(deck2.getListeCartes().size());

        ArrayList<Card> D = new ArrayList<>();
        for (Card carte : deck.getListeCartes()) {
            D.add(carte);
        }

        System.out.println(D.size());

        Collections.shuffle(D);
        Card carte = D.remove(0);
        System.out.println(carte.getFront().cardDisplayName);
        System.out.println(D.size());

    }

    @Test
    public void setDecksTest() {
        ArrayList<Joueur> listeJoueurs = new ArrayList<>();
        listeJoueurs.add(new Joueur("Romeo", 0, Wonder.Gizeh));
        ArrayList<Decks> decks = new ArrayList<>();
        Random R = new Random();
        for (Decks D : Decks.values()) {
            decks.add(D);
        }
        for (Joueur J : listeJoueurs) {
            J.setSelfDeck(decks.remove(R.nextInt(decks.size())));
        }
    }

    @Test
    public void testPartie() {

        FenetrePrincipale fp = new FenetrePrincipale();
        ArrayList<String> listeJoueurs = new ArrayList<>();
        listeJoueurs.add("Romeo");
        listeJoueurs.add("J2");
        listeJoueurs.add("J3");
        listeJoueurs.add("J4");

        Partie partie = new Partie(4, listeJoueurs, fp);
        fp.setWonder(partie.getJoueurs());
        fp.setDecks(partie.getJoueurs());
        for (Joueur J : partie.getJoueurs()) {
            //System.out.println(J.getWonder().displayName);
            System.out.println((J.getSelfDeck()));
            System.out.println("A droite " + (J.getRightDeck()));
        }
    }
}
