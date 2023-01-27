package fr.isep.javarchitects.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerModel {
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final ObjectProperty<Wonder> wonder = new SimpleObjectProperty<>();
    private final ObjectProperty<DeckModel> selfDeck = new SimpleObjectProperty<>();
    private final ObjectProperty<DeckModel> rightDeck = new SimpleObjectProperty<>();
    private final ObservableList<Card> ownedCardList = FXCollections.observableArrayList();
    private final ObservableList<ProgressToken> ownedProgressTokensList = FXCollections.observableArrayList();
    private final SimpleIntegerProperty playerGloryPoints = new SimpleIntegerProperty();
    private final SimpleIntegerProperty playerWarPoints = new SimpleIntegerProperty();
    private final SimpleIntegerProperty vpWonInBattle = new SimpleIntegerProperty();


    public void setName(String name){
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setWonder(Wonder wonder){
        this.wonder.set(wonder);
    }
    public Wonder getWonder() {
        return wonder.get();
    }

    public ObjectProperty<Wonder> wonderProperty() {
        return wonder;
    }

    public DeckModel getRightDeck() {
        return rightDeck.get();
    }

    public ObjectProperty<DeckModel> rightDeckProperty() {
        return rightDeck;
    }

    public void setRightDeck(DeckModel rightDeck) {
        this.rightDeck.set(rightDeck);
    }

    public DeckModel getSelfDeck() {
        return selfDeck.get();
    }

    public ObjectProperty<DeckModel> selfDeckProperty() {
        return selfDeck;
    }

    public void setSelfDeck(DeckModel selfDeck) {
        this.selfDeck.set(selfDeck);
    }

    public ObservableList<Card> getOwnedCardList(){
        return ownedCardList;
    }
    public void addCard(Card card) {
        ownedCardList.add(card);
        if (card.cardCategory == CardCategory.PoliticCard) {
            this.setPlayerGloryPoints(this.getPlayerGloryPoints() + card.laurelCount);
        }
        else if (card.cardCategory == CardCategory.WarCard) {
            this.setPlayerWarPoints(this.getPlayerWarPoints() + card.shieldCount);
        }
    }

    public ImmutableCardByTypeCounts getAvailableCardCounters() {
        return new ImmutableCardByTypeCounts(ownedCardList);
    }

    public ImmutableMaterialCardByTypeCounts getAvailableMaterialCardCounts() {
        return new ImmutableMaterialCardByTypeCounts(getAvailableCardCounters());
    }

    public void removeMaterialCardByTypeCounts(ImmutableMaterialCardByTypeCounts cardsUsed) {
        for (Material material: Material.values()){
            for (int i = 0; i < cardsUsed.get(material); i++) {
                for (Card card : ownedCardList) {
                    if (card.material == material){
                        ownedCardList.remove(card);
                        break;
                    }
                }
            }
        }
    }

    public void removeCardByTypeCounts(ImmutableCardByTypeCounts cardsUsed) {
        for (Card cardType : Card.values()){
            for (int i = 0; i < cardsUsed.get(cardType); i++) {
                for (Card card : ownedCardList) {
                    if (card == cardType){
                        ownedCardList.remove(card);
                        break;
                    }
                }
            }
        }
    }

    public void addProgress(ProgressToken token) {
        this.ownedProgressTokensList.add(token);
    }

    public int getPlayerGloryPoints() {
        return (int) playerGloryPoints.get();
    }
    
    public void setPlayerGloryPoints(int gloryPoints) {
        this.playerGloryPoints.set(gloryPoints);
    }

    public ObservableIntegerValue playerGloryPointsProperty() {
        return playerGloryPoints;
    }

    public ObservableIntegerValue playerWarPointsProperty() {
        return  playerWarPoints;
    }
    public ObservableList<ProgressToken> ownedProgressTokensListProperty() {return ownedProgressTokensList;}

    public int getPlayerWarPoints() {
        return playerWarPoints.get();
    }

    public ObservableList<ProgressToken> getOwnedProgressTokensList() {
        return ownedProgressTokensList;
    }

    public void setPlayerWarPoints(int warPoints) {
        this.playerWarPoints.set(warPoints);
    }

    public ObservableIntegerValue vpWonInBattleProperty(){
        return vpWonInBattle;
    }
    public int getVpWonInBattle(){
        return vpWonInBattle.get();
    }

    public void addBattleToken(int numberOfTokens) {
        this.vpWonInBattle.set(this.getVpWonInBattle() + (numberOfTokens * 3));
    }

    public void removeHorns() {
        ownedCardList.removeIf(card -> {
            if (card.cardCategory == CardCategory.WarCard && card.cornCount > 0){
                playerWarPoints.set(this.getPlayerWarPoints() - 1);
                return true;
            }
            return false;
        });
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "name=" + name +
                ", wonder=" + wonder.get().displayName +
                ", playerGloryPoints=" + playerGloryPoints +
                ", playerWarPoints=" + playerWarPoints +
                ", vpWonInBattle=" + vpWonInBattle +
                '}';
    }

    public boolean hasCat() {
        return false;
    }
}
