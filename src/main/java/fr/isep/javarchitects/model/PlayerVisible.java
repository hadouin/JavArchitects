package fr.isep.javarchitects.model;

import java.util.List;

public class PlayerVisible {
    public final Wonder wonder;
    public final Card topDeck;
    public final List<Card> cards;
    public final List<ProgressToken> progressTokens;
    public final boolean hasCat;

    public PlayerVisible(Wonder wonder, Card topDeck, List<Card> cards, List<ProgressToken> progressTokens, boolean hasCat) {
        this.wonder = wonder;
        this.topDeck = topDeck;
        this.cards = cards;
        this.progressTokens = progressTokens;
        this.hasCat = hasCat;
    }

    public boolean getHasCat() {
        return this.hasCat;
    }
}
