package fr.isep.javarchitects.core;

import fr.isep.javarchitects.model.DeckModel;
import fr.isep.javarchitects.model.PlayerModel;
import javafx.collections.ObservableList;

import java.util.*;

public class GameUtils {

    public static void setRandomWonder(ObservableList<PlayerModel> listePlayers) {
        Random R = new Random();
        ArrayList<Wonder> listeWonder = new ArrayList<>();
        for (WonderFactory W : WonderFactory.values()) {
            listeWonder.add(W.createWonder());
        }

        for (PlayerModel J : listePlayers) {
            int C = R.nextInt(listeWonder.size());
            J.setWonder(listeWonder.remove(C));
        }
    }

    /**
     * fonction qui va assigner à chaque joueur deux decks : son propre deck, positionné à sa gauche,
     * et le deck de son voisin de droite
     * @param listePlayers liste des joueurs ordonnée dans l'ordre
     */
    public static void setDecks(ObservableList<PlayerModel> listePlayers) {

        // set self deck in function of wonder
        for (PlayerModel player : listePlayers) {
            DeckModel deck = player.getWonder().createDeck();
            player.setSelfDeck(deck);
        }

        // set right deck to i+1 in the list
        // if last get right deck of first player
        for( int i = 0; i < listePlayers.size(); i++) {
            PlayerModel player = listePlayers.get(i);
            if (i != listePlayers.size() - 1){
                player.setRightDeck(listePlayers.get(i + 1).getSelfDeck());
            } else {
                player.setRightDeck(listePlayers.get(0).getSelfDeck());
            }
        }
    }

    /**
     * @param playerList list to query
     * @return the first player that owns the cat. If none have the Cat returns null
     */
    public static Player getCatOwner(List<Player> playerList){
        return playerList.stream()
                .filter(Player::getHasCat)
                .findFirst()
                .orElse(null);
    }

    public static List<WonderFragment> getBuildableFragments(Player player){
        List<WonderFragment> buildableFragments = player.getWonder().getWonderFragments().stream()
                .filter(fragment -> !fragment.getIsBuilt() && player.getWonder().isFloorOpen(fragment.getFloorNumber()) && hasMaterialToBuild(player, fragment))
                .toList();
        return buildableFragments;
    }

    private static boolean hasMaterialToBuild(Player player, WonderFragment fragment){
        List<Card> ownedMaterialCards = player.getOwnedCards().stream()
                .filter(card -> card.cardCategory == CardCategory.MaterialCard).toList();
        return hasMaterialCombination(ownedMaterialCards, fragment.getResourceCount(), fragment.isMatchingResources());
    }

    private static boolean hasMaterialCombination(List<Card> materialCardList, int nMaterial, boolean matching){
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

    public static int getMaxConflictTokens(int nbPlayers){
        int[] tokenForPlayerNb = {3,3,3,3,4,5,6,6};
        return tokenForPlayerNb[nbPlayers];
    }
}
