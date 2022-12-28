package JeuDePlateau;

import fr.isep.javarchitects.Decks;
import fr.isep.javarchitects.Wonder;

public class Joueur {

    private String nom;
    private int ID;
    private Wonder wonder;
    private int pointsDeVictoire = 0;
    private int pointCombats = 0;
    private boolean possedeLeChat = false;
    private Decks SelfDeck;
    private Decks rightDeck;
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

    public int getPointCombats() {
        return pointCombats;
    }

    public boolean isPossedeLeChat() {
        return possedeLeChat;
    }

    public Decks getSelfDeck() {
        return SelfDeck;
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

    public void setPointCombats(int pointCombats) {
        this.pointCombats = pointCombats;
    }

    public void setPossedeLeChat(boolean possedeLeChat) {
        this.possedeLeChat = possedeLeChat;
    }

    public void setSelfDeck(Decks selfDeck) {
        SelfDeck = selfDeck;
    }

    public void setRightDeck(Decks rightDeck) {
        this.rightDeck = rightDeck;
    }
}
