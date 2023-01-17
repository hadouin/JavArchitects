package fr.isep.javarchitects.model;

import java.util.List;

public class Deck {
    private List<Card> cards;
    private final CardBack cardBack;

    public Deck(CardBack cardBack, Card... cards) {
        this.cards = List.of(cards);
        this.cardBack = cardBack;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public CardBack getCardBack() {
        return cardBack;
    }
}
