package fr.isep.javarchitects.model;

import java.util.List;

public class PlayerVisible {
    public final String name;
    public final Wonder wonder;
    public final Card topDeck;
    public final List<Card> cards;
    public final List<ProgressToken> progressTokens;
    public final int warPoints;
    public final int gloryPoint;
    public final boolean hasCat;

    public PlayerVisible(String name, Wonder wonder, Card topDeck, List<Card> cards, List<ProgressToken> progressTokens, int warPoints, int gloryPoint, boolean hasCat) {
        this.name = name;
        this.wonder = wonder;
        this.topDeck = topDeck;
        this.cards = cards;
        this.progressTokens = progressTokens;
        this.warPoints = warPoints;
        this.gloryPoint = gloryPoint;
        this.hasCat = hasCat;
    }

    public PlayerVisible(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
        progressTokens = null;
        hasCat = false;
        topDeck = null;
        wonder = null;
        warPoints = 0;
        gloryPoint = 0;

    };

    public boolean getHasCat() {
        return this.hasCat;
    }
}
