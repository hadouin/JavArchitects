package fr.isep.javarchitects.model;

public class Player {

    private String name;
    private int ID;
    private Wonder wonder;
    private int victoryPoints = 0;
    private int warPoints = 0;
    private boolean ownsCat = false;
    private Decks selfDeck;
    private Decks rightDeck;

    Player(Builder builder){
        this.name = builder.name;
        this.ID = builder.ID;
        this.wonder = builder.wonder;
        this.victoryPoints = builder.victoryPoints;
        this.warPoints = builder.warPoints;
        this.ownsCat = builder.ownsCat;
        this.selfDeck = builder.selfDeck;
    }

    public static class Builder {
        // Params obligatoires
        private final String name;
        private final int ID;

        // Params facultatifs
        private Wonder wonder = Wonder.Gizeh;
        private int victoryPoints = 0;
        private int warPoints = 0;
        private boolean ownsCat = false;
        private Decks selfDeck = Decks.D_Gizeh;

        public Builder(String name, int id) {
            this.name = name;
            ID = id;
        }
        public Builder setWonder(Wonder wonder){
            this.wonder = wonder; return this;
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

        public Player build(){
            return new Player(this);
        }

    }
    public Player(String name, int ID, Wonder wonder) {
        this.name = name;
        this.ID = ID;
        this.wonder = wonder;
    }

    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
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

    public boolean getOwnsCat() {
        return ownsCat;
    }

    public Decks getSelfDeck() {
        return selfDeck;
    }

    public Decks getRightDeck() {
        return rightDeck;
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

    public void setOwnsCat(boolean ownsCat) {
        this.ownsCat = ownsCat;
    }

    public void setSelfDeck(Decks selfDeck) {
        selfDeck = selfDeck;
    }

    public void setRightDeck(Decks rightDeck) {
        this.rightDeck = rightDeck;
    }
}
