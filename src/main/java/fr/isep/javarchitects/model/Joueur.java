package fr.isep.javarchitects.model;

public class Joueur {

    private String nom;
    private int ID;
    private Wonder wonder;
    private int pointsDeVictoire = 0;
    private int pointDeGuerre = 0;
    private boolean possedeLeChat = false;
    private Decks selfDeck;
    private Decks rightDeck;

    Joueur(Builder builder){
        this.nom = builder.nom;
        this.ID = builder.ID;
        this.wonder = builder.wonder;
        this.pointsDeVictoire = builder.pointsDeVictoire;
        this.pointCombats = builder.pointCombats;
        this.possedeLeChat = builder.possedeLeChat;
        this.selfDeck = builder.selfDeck;
    }

    public static class Builder {
        // Params obligatoires
        private final String nom;
        private final int ID;

        // Params facultatifs
        private Wonder wonder = Wonder.Gizeh;
        private int pointsDeVictoire = 0;
        private int pointCombats = 0;
        private boolean possedeLeChat = false;
        private Decks selfDeck = Decks.D_Gizeh;

        public Builder(String name, int id) {
            this.nom = name;
            ID = id;
        }
        public Builder setWonder(Wonder wonder){
            this.wonder = wonder; return this;
        }
        public Builder setPointsDeVictoire(int pointsDeVictoire){
            this.pointsDeVictoire = pointsDeVictoire; return this;
        }
        public Builder setPointCombats(int pointCombats) {
            this.pointCombats = pointCombats; return this;
        }
        public Builder setPossedeLeChat(boolean possedeLeChat) {
            this.possedeLeChat = possedeLeChat; return this;
        }
        public Builder setSelfDeck(Decks selfDeck) {
            this.selfDeck = selfDeck; return this;
        }

        public Joueur build(){
            return new Joueur(this);
        }

    }
    public Joueur(String nom, int ID, Wonder wonder) {
        this.nom = nom;
        this.ID = ID;
        this.wonder = wonder;
    }

    public Joueur(String nom, int ID) {
        this.nom = nom;
        this.ID = ID;
    }

    //-------------------------------------------------------------

    public String getNom() {
        return nom;
    }

    public int getID() {
        return ID;
    }

    public Wonder getWonder() {
        return wonder;
    }

    public int getPointsDeVictoire() {
        return pointsDeVictoire;
    }

    public int getPointDeGuerre() {
        return pointDeGuerre;
    }

    public boolean isPossedeLeChat() {
        return possedeLeChat;
    }

    public Decks getSelfDeck() {
        return selfDeck;
    }

    public Decks getRightDeck() {
        return rightDeck;
    }

    //-------------------------------------------------------------

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setWonder(Wonder wonder) {
        this.wonder = wonder;
    }

    public void setPointsDeVictoire(int pointsDeVictoire) {
        this.pointsDeVictoire = pointsDeVictoire;
    }

    public void setPointDeGuerre(int pointDeGuerre) {
        this.pointDeGuerre = pointDeGuerre;
    }

    public void setPossedeLeChat(boolean possedeLeChat) {
        this.possedeLeChat = possedeLeChat;
    }

    public void setSelfDeck(Decks selfDeck) {
        selfDeck = selfDeck;
    }

    public void setRightDeck(Decks rightDeck) {
        this.rightDeck = rightDeck;
    }
}
