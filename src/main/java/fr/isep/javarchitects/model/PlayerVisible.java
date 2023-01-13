package fr.isep.javarchitects.model;

import java.util.List;

public class PlayerVisible {
    public final String name;
    public final Wonder wonder;
    public final Card leftTopDeck;
    public final Card rightTopDeck;
    public int leftDeckTotal;
    public int rightDeckTotal;
    public final List<Card> cards;
    public final List<ProgressToken> progressTokens;
    public final int warPoints;
    public final int gloryPoint;
    public final boolean hasCat;

    public PlayerVisible(Builder builder){
        this.name = builder.name;
        this.wonder = builder.wonder;
        this.leftTopDeck = builder.leftTopDeck;
        this.rightTopDeck = builder.rightTopDeck;
        this.leftDeckTotal = builder.leftDeckTotal;
        this.rightDeckTotal = builder.rightDeckTotal;
        this.cards = builder.cards;
        this.progressTokens = builder.progressTokens;
        this.hasCat = builder.hasCat;
        this.gloryPoint = builder.gloryPoints;
        this.warPoints = builder.warPoints;
    }

    static class Builder {
        private String name;
        private Wonder wonder;
        private Card leftTopDeck;
        private Card rightTopDeck;
        private int leftDeckTotal;
        private int rightDeckTotal;
        private List<Card> cards;
        private List<ProgressToken> progressTokens;
        private boolean hasCat;
        private int gloryPoints;
        private int warPoints;

        public Builder setName(String name) {
            this.name = name; return this;
        }

        public Builder setWonder(Wonder wonder) {
            this.wonder = wonder; return this;
        }

        public Builder setLeftDeck(Card topdeck, int total) {
            this.leftTopDeck = topdeck;
            this.leftDeckTotal = total;
            return this;
        }

        public Builder setRightDeck(Card topdeck, int total) {
            this.rightTopDeck = topdeck;
            this.rightDeckTotal = total;
            return this;
        }

        public Builder setCards(List<Card> cards) {
            this.cards = cards; return this;
        }

        public Builder setProgressTokens(List<ProgressToken> progressTokens) {
            this.progressTokens = progressTokens; return this;
        }

        public Builder setHasCat(boolean hasCat) {
            this.hasCat = hasCat; return this;
        }

        public PlayerVisible build(){
            return new PlayerVisible(this);
        }

        public Builder setWarPoints(int warPoints) {
            this.warPoints = warPoints; return this;
        }

        public Builder setGloryPoints(int gloryPoints) {
            this.gloryPoints = gloryPoints; return this;
        }
    }
    
    public boolean getHasCat() {
        return this.hasCat;
    }
}
