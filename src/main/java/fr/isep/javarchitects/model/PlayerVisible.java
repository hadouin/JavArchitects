package fr.isep.javarchitects.model;

import java.util.List;

public class PlayerVisible {
    public final String name;
    public final Wonder wonder;
    public final Card topDeck;
    public final List<Card> cards;
    public final List<ProgressToken> progressTokens;
    public final boolean hasCat;

    public PlayerVisible(String name, Wonder wonder, Card topDeck, List<Card> cards, List<ProgressToken> progressTokens, boolean hasCat) {
        this.name = name;
        this.wonder = wonder;
        this.topDeck = topDeck;
        this.cards = cards;
        this.progressTokens = progressTokens;
        this.hasCat = hasCat;
    }

    public PlayerVisible(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
        progressTokens = null;
        hasCat = false;
        topDeck = null;
        wonder = null;

    };

    public boolean getHasCat() {
        return this.hasCat;
    }
}
