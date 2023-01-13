package fr.isep.javarchitects.model;

import java.util.List;

public class PlayerVisible {
    public final Wonder wonder;
    public final Card leftTopDeck;
    public final Card rightTopDeck;
    public int leftDeckTotal;
    public int rightDeckTotal;
    public final List<Card> cards;
    public final List<ProgressToken> progressTokens;
    public final boolean hasCat;

    public PlayerVisible(Builder builder){
        this.wonder = builder.wonder;
        this.leftTopDeck = builder.leftTopDeck;
        this.rightTopDeck = builder.rightTopDeck;
        this.leftDeckTotal = builder.leftDeckTotal;
        this.rightDeckTotal = builder.rightDeckTotal;
        this.cards = builder.cards;
        this.progressTokens = builder.progressTokens;
        this.hasCat = builder.hasCat;
    }

    static class Builder {
        private Wonder wonder;
        private Card leftTopDeck;
        private Card rightTopDeck;
        private int leftDeckTotal;
        private int rightDeckTotal;
        private List<Card> cards;
        private List<ProgressToken> progressTokens;
        private boolean hasCat;


        public void setWonder(Wonder wonder) {
            this.wonder = wonder;
        }

        public void setLeftDeck(Card topdeck, int total) {
            this.leftTopDeck = topdeck;
            this.leftDeckTotal = total;
        }

        public void setRightDeck(Card topdeck, int total) {
            this.rightTopDeck = topdeck;
            this.rightDeckTotal = total;
        }

        public void setCards(List<Card> cards) {
            this.cards = cards;
        }

        public void setProgressTokens(List<ProgressToken> progressTokens) {
            this.progressTokens = progressTokens;
        }

        public void setHasCat(boolean hasCat) {
            this.hasCat = hasCat;
        }

        public PlayerVisible build(){
            return new PlayerVisible(this);
        }
    }


    public PlayerVisible(Wonder wonder, Card topDeck, Card rightTopDeck, List<Card> cards, List<ProgressToken> progressTokens, boolean hasCat) {
        this.wonder = wonder;
        this.leftTopDeck = topDeck;
        this.rightTopDeck = rightTopDeck;
        this.cards = cards;
        this.progressTokens = progressTokens;
        this.hasCat = hasCat;
    }

    public boolean getHasCat() {
        return this.hasCat;
    }
}
