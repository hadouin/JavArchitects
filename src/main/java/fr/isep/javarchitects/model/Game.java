package fr.isep.javarchitects.model;

import fr.isep.javarchitects.controllers.GameController;
import fr.isep.javarchitects.model.command.DrawCard;
import fr.isep.javarchitects.model.command.GameAction;

import java.util.*;
import java.util.stream.Collectors;


public class Game {
    private GameController gameController;
    private int nbPlayers;
    private List<Player> players;
    private int currentPlayerID = 0;
    private int nbRound = 1;
    private List<GameAction> activeActionsList = new ArrayList<>();
    private Deck centerDeck;

    public List<ConflictToken> conflictTokens = Arrays.asList(
            new ConflictToken(false),
            new ConflictToken(false),
            new ConflictToken(true)
    );
    private List<ProgressToken> progressTokenList = ProgressTokens.TOKENS.subList(5,11);

    // -----------------------------------------------------------------------------------------------------------------
    public Game(int nbPlayers, List<String> playerNames) {
        this.nbPlayers = nbPlayers;
        this.players = new ArrayList<>();
        for(int i = 0; i < this.nbPlayers; i++){
            players.add(new Player(playerNames.get(i), i, WonderFactory.Alexandria.createWonder()));
        }
        setWonder(players);
        setDecks(players);
        this.centerDeck = DeckFactory.Extra.createDeck();
    }

    public void startDrawPhase() {
        activeActionsList.clear();
        DrawCard currentPlayerDrawLeft = new DrawCard(this, "Draw Left", getCurrentPlayer(), getCurrentPlayer().getSelfDeck().getCards());
        DrawCard currentPlayerDrawCenter = new DrawCard(this,"Draw Center", getCurrentPlayer(), centerDeck.getCards());
        DrawCard currentPlayerDrawRight = new DrawCard(this,"Draw Right", getCurrentPlayer(), getCurrentPlayer().getRightDeck().getCards());

        activeActionsList.addAll(Arrays.asList(
                currentPlayerDrawLeft,
                currentPlayerDrawCenter,
                currentPlayerDrawRight
        ));
        gameController.setVisibleState(getVisibleState());
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerID);
    }

    public void startGame(){

    };

    /**
     * Set current player ID to next player
     * go back to first if last and add a round
     */
    public void setNextPlayer() {
        currentPlayerID++;
        if (currentPlayerID >= this.nbPlayers) {
            this.currentPlayerID = 0;
            this.nbRound++;
        }
    }

    /**
     * Fonction qui va assigner à chaque joueur de listeJoueurs merveille.
     * De manière random
     * @param listePlayers liste des joueurs à traiter
     */
    public void setWonder(List<Player> listePlayers) {
        Random R = new Random();
        ArrayList<Wonder> listeWonder = new ArrayList<>();
        for (WonderFactory W : WonderFactory.values()) {
            listeWonder.add(W.createWonder());
        }

        for (Player J : listePlayers) {
            int C = R.nextInt(listeWonder.size());
            J.setWonder(listeWonder.remove(C));
        }
    }

    /**
     * fonction qui va assigner à chaque joueur deux decks : son propre deck, positionné à sa gauche,
     * et le deck de son voisin de droite
     * @param listePlayers liste des joueurs ordonnée dans l'ordre
     */
    public void setDecks(List<Player> listePlayers) {

        // set self deck in function of wonder
        for (Player player : listePlayers) {
            Deck deck = player.getWonder().createDeck();
            player.setSelfDeck(deck);
        }

        // set right deck to i+1 in the list
        // if last get right deck of first player
        for( int i = 0; i < listePlayers.size(); i++) {
            Player player = listePlayers.get(i);
            if (i != listePlayers.size() - 1){
                player.setRightDeck(listePlayers.get(i + 1).getSelfDeck());
            } else {
                player.setRightDeck(listePlayers.get(0).getSelfDeck());
            }
        }
    }

    /**
     * 09/01/23 Moved from GameStateVisible
     * @param nbPlayers number of players in the game
     * @return the number of conflict tokens for the game
     */
    private int calcMaxConflictTokens(int nbPlayers){
        int[] tokenForPlayerNb = {3,3,3,3,4,5,6,6};
        return tokenForPlayerNb[nbPlayers];
    }

    /**
     * @param playerList list to query
     * @return the first player that owns the cat. If none have the Cat returns null
     */
    public Player getCatOwner(List<Player> playerList){
        return playerList.stream()
                .filter(Player::getHasCat)
                .findFirst()
                .orElse(null);
    }

    /**
     * @param player player to test
     * @return the list of fragments the player can build
     */
    List<WonderFragment> getBuildableFragments(Player player){
        List<WonderFragment> buildableFragments = player.getWonder().getWonderFragments().stream()
                .filter(fragment -> !fragment.getIsBuilt() && player.getWonder().isFloorOpen(fragment.getFloorNumber()) && hasMaterialToBuild(player, fragment))
                .toList();
        return buildableFragments;
    }

    /**
     * @param player player that wants to build
     * @param fragment fragment to build
     * @return true if fragment buildable by player
     */
    private boolean hasMaterialToBuild(Player player, WonderFragment fragment){
        List<Card> ownedMaterialCards = player.getOwnedCards().stream()
                .filter(card -> card.cardCategory == CardCategory.MaterialCard).toList();
        return hasMaterialCombination(ownedMaterialCards, fragment.getResourceCount(), fragment.isMatchingResources());
    }

    /**
     * @param materialCardList list of materialCards
     * @return true if the combination is present in list
     */
    private boolean hasMaterialCombination(List<Card> materialCardList, int nMaterial, boolean matching){
        // if the player has less card than the number needed return false
        if (materialCardList.size() < nMaterial){
            return false;
        }
        // Create a hashmap that contains unique cards and their number of occurrence
        Map<Card, Integer> map = new HashMap<>();
        for (Card card : materialCardList) {
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }
        // if we need matching cards return if a card
        if (matching){
            for ( Map.Entry<Card, Integer> entry : map.entrySet()) {
                int occurrence = entry.getValue();
                if (map.containsKey(Card.CardMaterialGold) && entry.getKey() != Card.CardMaterialGold){
                    occurrence += map.get(Card.CardMaterialGold);
                }
                if (occurrence >= nMaterial){
                    return true;
                }
            }
        } else {
            int differentMaterials = map.size();
            if (map.containsKey(Card.CardMaterialGold)){
                differentMaterials += (map.get(Card.CardMaterialGold) - 1);
            }
            return differentMaterials >= nMaterial;
        }
        return false;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public void setController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public List<Player> getPlayers() {
        return players;
    }
    public int getNbPlayers() {
        return nbPlayers;
    }
    public Player getCurrentPlayerID() {
        return players.get(currentPlayerID);
    }

    /**
     * @return the visible elements of the current state of the game
     */
    public GameStateVisible getVisibleState() {
        return new GameStateVisible(
                players.stream()
                        .map(Player::getVisibleState)
                        .collect(Collectors.toList()),
                0,
                conflictTokens,
                progressTokenList.subList(0,3),
                activeActionsList
        );
    }
}

