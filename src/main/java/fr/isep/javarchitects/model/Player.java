package fr.isep.javarchitects.model;

import java.util.List;

public class Player {

    private String name;
    private int ID;
    private Wonder wonder;
    private int victoryPoints = 0;
    private int warPoints = 0;
    private boolean hasCat = false;
    private Decks selfDeck;
    private Decks rightDeck;
    private List<Card> ownedCards;
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
        private Decks selfDeck = Decks.D_Gizeh;
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
        public Builder setSelfDeck(Decks selfDeck) {
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
        this.selfDeck = Decks.values()[wonder.getID()];
    }
    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public PlayerVisible getVisibleState(){
        PlayerVisible playerVisible = new PlayerVisible(wonder, getTopDeck(), getOwnedCards(), getProgressTokens(), hasCat);
        return playerVisible;
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

    public Decks getSelfDeck() {
        return selfDeck;
    }

    public Decks getRightDeck() {
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

    public void setSelfDeck(Decks selfDeck) {
        selfDeck = selfDeck;
    }

    public void setRightDeck(Decks rightDeck) {
        this.rightDeck = rightDeck;
    }

    public List<Card> getOwnedCards() {
        return this.ownedCards;
    }

    private Card getTopDeck(){
        return this.selfDeck.getListeCartes().get(0);
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
