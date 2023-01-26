package fr.isep.javarchitects.core;

import com.google.common.collect.ImmutableList;
import fr.isep.javarchitects.model.DeckModel;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.model.command.BuildWonderFragUsingCards;
import fr.isep.javarchitects.utils.ImmutableMaterialCardByTypeCounts;
import javafx.scene.control.IndexRange;

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
                .filter(fragment -> !fragment.isBuilt() && player.getWonder().isFloorOpen(fragment.getFloorNumber()) && hasMaterialToBuild(player, fragment))
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
                .filter(fragment -> !fragment.isBuilt() && player.getWonder().isFloorOpen(fragment.getFloorNumber()))
                .toList();
        List<BuildWonderFragUsingCards> res = new ArrayList<>();
        for (WonderFragment fragment: buildableFragments) {
            List<BuildWonderFragUsingCards> moves =  listMoveBuildWonderFragment(player, fragment, game);
            // Iterate through the list and remove elements with the same card counts
            filterSimilarMoves(moves);
            res.addAll(moves);
        }
        return res;
    }

    public static List<BuildWonderFragUsingCards> listMoveBuildWonderFragment(
            PlayerModel p, WonderFragment frag, GameModel game) {
        ArrayList<BuildWonderFragUsingCards> res = new ArrayList<>();
        boolean fragNeedSameMaterial = frag.isMatchingResources();
        int requiredAmount = frag.getResourceCount();

        // available material card counts
        ImmutableMaterialCardByTypeCounts availableMaterialCardCounts = p.getAvailableMaterialCardCounts();

        if (availableMaterialCardCounts.getTotalCount() < requiredAmount) {
            return res;
        }

        if (fragNeedSameMaterial) {
            listMoveBuildWonderFragment_similarMaterial(frag, res, requiredAmount, availableMaterialCardCounts, game);
        } else {
//          recursiveListMoveBuildWonderFragment_differentMaterials(res, frag, 0, currUsedCounts, requiredAmount, availableMaterialCardCounts, game);
            res.addAll(findCombinations(availableMaterialCardCounts.getHashMap(), frag, game));
        }
        return res;
    }

    private static void listMoveBuildWonderFragment_similarMaterial(
            WonderFragment frag,
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
            int remainingRequiredAmount, //
            ImmutableMaterialCardByTypeCounts materialCardCounts, GameModel game) {
        Material material = materialExceptGolds.get(currMaterialIndex);
        int count = materialCardCounts.get(material);
        if (count > 0) {
            // selecting 1 card of this material
            ImmutableMaterialCardByTypeCounts.Builder nextUsedCounts = currUsedCounts.cloneBuilderWithSelect(material);
            int nextRemainingRequiredAmount = remainingRequiredAmount - 1;
            if (nextRemainingRequiredAmount == 0) {
                // no need to recurse
                ImmutableMaterialCardByTypeCounts usedCards = nextUsedCounts.build();
                if (usedCards.getTotalCount() == frag.getResourceCount()){
                    res.add(new BuildWonderFragUsingCards(game, frag, usedCards));
                }
            } else {
                int nextIndex = currMaterialIndex + 1;
                if (nextIndex <= materialExceptGolds.size() - 1) {
                    // recurse
                    recursiveListMoveBuildWonderFragment_differentMaterials(res, frag,
                            nextIndex, nextUsedCounts, nextRemainingRequiredAmount, materialCardCounts, game);
                }
            }
        }
        // handle gold each time
        int currTotal = currUsedCounts.build().getTotalCount();
        if (materialCardCounts.goldCount + currTotal>= frag.getResourceCount()){
            // complete with some joker Gold(s)
            ImmutableMaterialCardByTypeCounts usedCardsWithGolds = ImmutableMaterialCardByTypeCounts.builder()
                    .with(Material.Gold, frag.getResourceCount() - currTotal)
                    .build();
            if (usedCardsWithGolds.getTotalCount() == frag.getResourceCount()){
                res.add(new BuildWonderFragUsingCards(game, frag, usedCardsWithGolds));
            }
        }

        // recurse when not selecting this material
        int nextIndex = currMaterialIndex + 1;
        if (nextIndex <= materialExceptGolds.size() - 1) {
            // recurse
            recursiveListMoveBuildWonderFragment_differentMaterials(res, frag,
                    nextIndex, currUsedCounts, remainingRequiredAmount, materialCardCounts, game);
        }
    }

    public static List<BuildWonderFragUsingCards> findCombinations(HashMap<Material, Integer> map, WonderFragment frag, GameModel game) {
        List<BuildWonderFragUsingCards> combinations = new ArrayList<>();

        // Get all values from the map
        List<Material> materials = new ArrayList<>(map.keySet());

        if (map.containsKey(Material.Gold)){
            for (int i = 1; i < map.get(Material.Gold); i++){
                materials.add(Material.Gold);
            }
        }

        // Call the recursive helper function
        findCombinationsHelper(materials, frag, new ArrayList<>(), combinations, game);

        // Iterate through the list and remove elements with the same card counts
        filterSimilarMoves(combinations);

        return combinations;
    }

    private static void filterSimilarMoves(List<BuildWonderFragUsingCards> combinations) {
        Iterator<BuildWonderFragUsingCards> it = combinations.iterator();
        while (it.hasNext()) {
            BuildWonderFragUsingCards current = it.next();
            for (BuildWonderFragUsingCards bwfc : combinations) {
                if (current != bwfc && current.cardsUsed.equals(bwfc.cardsUsed)) {
                    it.remove();
                    break;
                }
            }
        }
    }

    private static void findCombinationsHelper(List<Material> materials, WonderFragment frag, List<Material> current, List<BuildWonderFragUsingCards> combinations, GameModel game) {
        if (current.size() == frag.getResourceCount()) {
            // If the current combination has the desired number of values, add it to the list of combinations
            ImmutableMaterialCardByTypeCounts.Builder builder = new ImmutableMaterialCardByTypeCounts.Builder();
            for (Material material :
                    current) {
                builder.add(material);
            }
            combinations.add(new BuildWonderFragUsingCards(game, frag, builder.build()));
            return;
        }

        for (int i = 0; i < materials.size(); i++) {
            // Choose a value
            Material material = materials.get(i);

            // Add it to the current combination
            current.add(material);

            // Remove it from the list of available materials
            materials.remove(i);

            // Recursively find more combinations
            findCombinationsHelper(materials, frag, current, combinations, game);

            // Backtrack - add the material back to the list of available materials
            materials.add(i, material);

            // Remove the value from the current combination
            current.remove(current.size() - 1);
        }
    }

    private static HashMap<String, Integer> scoresAtTheEndOfTheGame(Game game) {
        HashMap<String, Integer> pointMap = new HashMap<>();
        int i = 0;
        for (Player player : game.getPlayers()) {
            int points = player.getTotalPoints();
            Wonder wonder = player.getWonder();
            for(WonderFragment wonderFragment : wonder.getWonderFragments()) {
                if (wonderFragment.isBuilt()){
                    points += wonderFragment.getVP();
                }
            }
            pointMap.put(player.getName(), points);
        }

        return pointMap;
    }
}
