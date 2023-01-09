package fr.isep.javarchitects.model;

import fr.isep.javarchitects.model.Card;
import fr.isep.javarchitects.model.ProgressToken;
import fr.isep.javarchitects.model.Wonder;

import java.util.List;

public class PlayerVisible {
    private Wonder wonder;
    private Card topDeck;
    private List<Card> cards;
    private List<ProgressToken> progressTokens;

    public PlayerVisible(Wonder wonder, Card topDeck, List<Card> cards, List<ProgressToken> progressTokens) {
        this.wonder = wonder;
        this.topDeck = topDeck;
        this.cards = cards;
        this.progressTokens = progressTokens;
    }
}
