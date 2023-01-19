package fr.isep.javarchitects.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private final CardBack cardBack;

    public Deck(CardBack cardBack, Card... cards) {
        this.cards = new ArrayList<>(List.of(cards));
        Collections.shuffle(this.cards);
        this.cardBack = cardBack;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    public Card getFirstCard() {
        return cards.get(0);
    }

    public CardBack getCardBack() {
        return cardBack;
    }
}
