package fr.isep.javarchitects.model;

import java.util.ArrayList;
import java.util.List;

public enum DeckFactory {
    Alexandria(CardDecks.deckCardQuantities_Alexandria, CardBack.Alexandrie),
    Gizeh(CardDecks.deckCardQuantities_Gizeh, CardBack.Gizeh),
    Ephesus(CardDecks.deckCardQuantities_Ephesus, CardBack.Ephesus),
    Halicarnassus(CardDecks.deckCardQuantities_Halicarnassus, CardBack.Halicarnassus),
    Rhodes(CardDecks.deckCardQuantities_Rhodes, CardBack.Rhodes),
    Babylon(CardDecks.deckCardQuantities_Babylon, CardBack.Babylon),
    Olympia(CardDecks.deckCardQuantities_Olympia, CardBack.Olympia),
    Extra(CardDecks.deckCardQuantities_Extra, CardBack.Extra);

    private List<CardDecks.CardQuantityType> deckCardQuantities;
    private CardBack cardBack;

    DeckFactory(List<CardDecks.CardQuantityType> deckCardQuantities, CardBack cardBack) {
        this.deckCardQuantities = deckCardQuantities;
        this.cardBack = cardBack;
    }

    public Deck createDeck() {
        return new Deck(cardBack, getCardsFromCardQuantities(deckCardQuantities));
    };

    public static Card[] getCardsFromCardQuantities(List<CardDecks.CardQuantityType> deckCardQuantities){
        List<Card> cards = new ArrayList<>();
        for (CardDecks.CardQuantityType cardQuantityType : deckCardQuantities) {
            for (int i = 0; i < cardQuantityType.quantity; i++) {
                cards.add(cardQuantityType.card);
            }
        }
        return cards.toArray(new Card[0]);
    }
}
