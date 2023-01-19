package fr.isep.javarchitects.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private String name;
    private int ID;
    private Wonder wonder;
    private int victoryPoints = 0;
    private int warPoints = 0;
    private boolean hasCat = false;
    private Deck selfDeck;
    private Deck rightDeck;
    private List<Card> ownedCards = new ArrayList<>();
    private List<ProgressToken> progressTokens;

    Player(Builder builder){
        this.name = builder.name;
        this.ID = builder.ID;
        this.wonder = builder.wonder;
        this.victoryPoints = builder.victoryPoints;
        this.warPoints = builder.warPoints;
        this.hasCat = builder.ownsCat;
        this.selfDeck = builder.selfDeck;
        this.ownedCards = builder.ownedCards;
    }

    public static class Builder {
        // Params obligatoires
        private final String name;
        private final int ID;
        private final Wonder wonder;

        // Params facultatifs
        private int victoryPoints = 0;
        private int warPoints = 0;
        private boolean ownsCat = false;
        private Deck selfDeck = DeckFactory.Gizeh.createDeck();
        private List<Card> ownedCards;

        public Builder(String name, int id, Wonder wonder) {
            this.name = name;
            ID = id;
            this.wonder = wonder;
        }
        public Builder setVictoryPoints(int victoryPoints){
            this.victoryPoints = victoryPoints; return this;
        }
        public Builder setWarPoints(int warPoints) {
            this.warPoints = warPoints; return this;
        }
        public Builder setOwnsCat(boolean ownsCat) {
            this.ownsCat = ownsCat; return this;
        }
        public Builder setSelfDeck(Deck selfDeck) {
            this.selfDeck = selfDeck; return this;
        }
        public Builder setOwnedCards(List<Card> ownedCards){
            this.ownedCards = ownedCards; return this;
        }

        public Player build(){
            return new Player(this);
        }

    }
    public Player(String name, int ID, Wonder wonder) {
        this.name = name;
        this.ID = ID;
        this.wonder = wonder;
        this.selfDeck = wonder.createDeck();
    }
    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public PlayerVisible getVisibleState(){
        return new PlayerVisible.Builder()
                .setName(name)
                .setWonder(wonder)
                .setRightDeck(getRightTopDeck(), rightDeck.getCards().size())
                .setLeftDeck(getLeftTopDeck(), selfDeck.getCards().size())
                .setCards(ownedCards)
                .build();
    }


    //-------------------------------------------------------------

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public Wonder getWonder() {
        return wonder;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public int getWarPoints() {
        return warPoints;
    }

    public boolean getHasCat() {
        return hasCat;
    }

    public Deck getSelfDeck() {
        // Collections.shuffle(selfDeck.getCards());
        return selfDeck;
    }

    public Deck getRightDeck() {
        return rightDeck;
    }

    public void addCard(Card card){
        this.ownedCards.add(card);
    }

    public void addProgressToken(ProgressToken token){
        this.progressTokens.add(token);
    }

    //-------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setWonder(Wonder wonder) {
        this.wonder = wonder;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public void setWarPoints(int warPoints) {
        this.warPoints = warPoints;
    }

    public void setHasCat(boolean hasCat) {
        this.hasCat = hasCat;
    }

    public void setSelfDeck(Deck selfDeck) {
        selfDeck = selfDeck;
    }

    public void setRightDeck(Deck rightDeck) {
        this.rightDeck = rightDeck;
    }

    public List<Card> getOwnedCards() {
        return this.ownedCards;
    }

    private Card getLeftTopDeck(){
        return this.selfDeck.getCards().get(0);
    }

    private Card getRightTopDeck(){
        return this.rightDeck.getCards().get(0);
    }

    private List<ProgressToken> getProgressTokens() {
        return this.progressTokens;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", wonder=" + wonder +
                ", victoryPoints=" + victoryPoints +
                '}';
    }
}
