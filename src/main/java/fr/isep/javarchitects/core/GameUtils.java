package fr.isep.javarchitects.core;

import com.google.common.collect.ImmutableList;
import fr.isep.javarchitects.model.DeckModel;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.core.command.BuildWonderFragUsingCards;
import fr.isep.javarchitects.utils.ImmutableMaterialCardByTypeCounts;

import java.util.*;

public class GameUtils {
    private static final ImmutableList<Material> materialExceptGolds = Material.allExceptGolds();

    public static void setRandomWonder(ArrayList<PlayerModel> listePlayers) {
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
    public static void setDecks(ArrayList<PlayerModel> listePlayers) {

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

    public static List<WonderFragment> getBuildableFragments(PlayerModel player){
        List<WonderFragment> buildableFragments = player.getWonder().getWonderFragments().stream()
                .filter(fragment -> !fragment.getIsBuilt() && player.getWonder().isFloorOpen(fragment.getFloorNumber()) && hasMaterialToBuild(player, fragment))
                .toList();
        return buildableFragments;
    }

    private static boolean hasMaterialToBuild(PlayerModel player, WonderFragment fragment){
        List<Card> ownedMaterialCards = player.getOwnedCardList().stream()
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

    public static List<BuildWonderFragUsingCards> getBuildingCombinations(PlayerModel player, GameModel game){
        List<WonderFragment> buildableFragments = player.getWonder().getWonderFragments().stream()
                .filter(fragment -> !fragment.getIsBuilt() && player.getWonder().isFloorOpen(fragment.getFloorNumber()))
                .toList();
        List<BuildWonderFragUsingCards> res = new ArrayList<>();
        for (WonderFragment fragment: buildableFragments) {
            List<BuildWonderFragUsingCards> moves =  listMoveBuildWonderFragment(player, fragment, game);
            // Iterate through the list and remove elements with the same card counts
            Iterator<BuildWonderFragUsingCards> it = moves.iterator();
            while (it.hasNext()) {
                BuildWonderFragUsingCards current = it.next();
                for (BuildWonderFragUsingCards bwfc : moves) {
                    if (current != bwfc && current.cardsUsed.equals(bwfc.cardsUsed)) {
                        it.remove();
                        break;
                    }
                }
            }
            res.addAll(moves);
        }
        return res;
    }

    public static List<BuildWonderFragUsingCards> listMoveBuildWonderFragment(
            PlayerModel p, WonderFragment frag, GameModel game) {
        ArrayList res = new ArrayList<BuildWonderFragUsingCards>();
        boolean fragNeedSameMaterial = frag.isMatchingResources();
        int requiredCount = frag.getResourceCount();

        // available material card counts
        ImmutableMaterialCardByTypeCounts availableMaterialCardCounts = p.getAvailableMaterialCardCounts();

        if (availableMaterialCardCounts.getTotalCount() < requiredCount) {
            return res;
        }

        if (fragNeedSameMaterial) {
            listMoveBuildWonderFragment_similarMaterial(frag, res, requiredCount, availableMaterialCardCounts, game);
        } else {
            ImmutableMaterialCardByTypeCounts.Builder currUsedCounts = ImmutableMaterialCardByTypeCounts.builder();
            recursiveListMoveBuildWonderFragment_differentMaterials(res, frag, 0, // currMaterialIndex
                    currUsedCounts, requiredCount, availableMaterialCardCounts, game);
        }
        return res;
    }

    private static void listMoveBuildWonderFragment_similarMaterial(WonderFragment frag,
                                                                    final List<BuildWonderFragUsingCards> res,
                                                                    final int requiredCount,
                                                                    final ImmutableMaterialCardByTypeCounts availableMaterialCardCounts, GameModel game) {
        int goldCount = availableMaterialCardCounts.goldCount;
        for(Material material: materialExceptGolds) {
            int count = availableMaterialCardCounts.get(material);
            if (count > 0) {
                if (count >= requiredCount) {
                    // enough similar cards to build fragment
                    ImmutableMaterialCardByTypeCounts usedCards = ImmutableMaterialCardByTypeCounts.builder().with(material, requiredCount).build();
                    res.add(new BuildWonderFragUsingCards(game, frag, usedCards));
                } else if (count + goldCount >= requiredCount) {
                    // complete with some joker Gold(s)
                    ImmutableMaterialCardByTypeCounts usedCards = ImmutableMaterialCardByTypeCounts.builder()
                            .with(material, count)
                            .with(Material.Gold, requiredCount-count)
                            .build();
                    res.add(new BuildWonderFragUsingCards(game ,frag, usedCards));
                }
            }
        }
        // special case for gold only ...
        if (goldCount >= requiredCount) {
            ImmutableMaterialCardByTypeCounts usedCards = ImmutableMaterialCardByTypeCounts.builder().with(Material.Gold, requiredCount).build();
            res.add(new BuildWonderFragUsingCards(game, frag, usedCards));
        }
    }

    private static void recursiveListMoveBuildWonderFragment_differentMaterials(
            List<BuildWonderFragUsingCards> res, //
            WonderFragment frag,
            int currMaterialIndex, //
            ImmutableMaterialCardByTypeCounts.Builder currUsedCounts,
            int remainingRequiredTypeCount, //
            ImmutableMaterialCardByTypeCounts materialCardCounts, GameModel game) {

        Material material = materialExceptGolds.get(currMaterialIndex);
        int count = materialCardCounts.get(material);
        if (count > 0) {
            // selecting 1 card of this material
            ImmutableMaterialCardByTypeCounts.Builder nextUsedCounts = currUsedCounts.cloneBuilderWithSelect(material);
            int nextRemainingRequiredTypes = remainingRequiredTypeCount - 1;
            remainingRequiredTypeCount--;
            if (nextRemainingRequiredTypes == 0) {
                // no need to recurse
                ImmutableMaterialCardByTypeCounts usedCards = nextUsedCounts.build();
                res.add(new BuildWonderFragUsingCards(game, frag, usedCards));
            } else {
                int nextIndex = currMaterialIndex + 1;
                if (nextIndex <= materialExceptGolds.size() - 1) {
                    // recurse
                    recursiveListMoveBuildWonderFragment_differentMaterials(res, frag,
                            nextIndex, nextUsedCounts, nextRemainingRequiredTypes, materialCardCounts, game);
                }

            }
        }
        // recurse when not selecting this material
        int nextIndex = currMaterialIndex + 1;
        if (nextIndex <= materialExceptGolds.size() - 1) {
            // recurse
            recursiveListMoveBuildWonderFragment_differentMaterials(res, frag,
                    nextIndex, currUsedCounts, remainingRequiredTypeCount, materialCardCounts, game);
        }
    }

}
