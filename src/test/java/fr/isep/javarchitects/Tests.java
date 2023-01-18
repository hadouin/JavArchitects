package fr.isep.javarchitects;

import fr.isep.javarchitects.core.*;
import org.junit.Test;

import java.util.*;

public class Tests {

    @Test
    public void test() {

        Deck deck = DeckFactory.Extra.createDeck();
        Deck deck2 = DeckFactory.Halicarnassus.createDeck();

        System.out.println(deck.getCards().size());
        System.out.println(deck2.getCards().size());

        ArrayList<Card> D = new ArrayList<>(deck.getCards());

        System.out.println(D.size());

        Collections.shuffle(D);
        Card carte = D.remove(0);
        System.out.println(carte.cardDisplayName);
        System.out.println(D.size());

    }

/*
    @Test
    public void setDecksTest() {
        ArrayList<Player> listePlayers = new ArrayList<>();
        listePlayers.add(new Player("Romeo", 0, WonderFactory.Gizeh.createWonder()));
        ArrayList<Decks> decks = new ArrayList<>();
        Random R = new Random();
        for (Decks D : Decks.values()) {
            decks.add(D);
        }
        for (Player J : listePlayers) {
            J.setSelfDeck(decks.remove(R.nextInt(decks.size())));
        }
    }
*/

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
