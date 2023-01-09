package fr.isep.javarchitects;

import fr.isep.javarchitects.model.*;
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
        ArrayList<Player> listePlayers = new ArrayList<>();
        listePlayers.add(new Player("Romeo", 0, Wonder.Gizeh));
        ArrayList<Decks> decks = new ArrayList<>();
        Random R = new Random();
        for (Decks D : Decks.values()) {
            decks.add(D);
        }
        for (Player J : listePlayers) {
            J.setSelfDeck(decks.remove(R.nextInt(decks.size())));
        }
    }

    @Test
    public void testPartie() {

        ArrayList<String> listeJoueurs = new ArrayList<>();
        listeJoueurs.add("Romeo");
        listeJoueurs.add("J2");
        listeJoueurs.add("J3");
        listeJoueurs.add("J4");

        Game game = new Game(4, listeJoueurs);
        for (Player J : game.getPlayers()) {
            //System.out.println(J.getWonder().displayName);
            System.out.println((J.getSelfDeck()));
            System.out.println("A droite " + (J.getRightDeck()));
        }
    }

    @Test
    public void testProgressToken() {
        List<ProgressToken> listToken = ProgressTokens.TOKENS;
        ProgressToken token = ProgressToken.Architecture;
        ArrayList<ProgressToken> L = new ArrayList<>();
        for(ProgressToken P : listToken) {
            L.add(P);
        }
        Collections.shuffle(L);
        for(int i = 0; i < listToken.size(); i++) {
            System.out.println(L.get(i).displayName);
        }
    }
}
