package fr.isep.javarchitects.model;

import fr.isep.javarchitects.command.BuildWonderFragUsingCards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameUtilsTest {

    @Test
    void listMoveBuildWonderFragment() {
        // Arrange
        GameModel game = new GameModel();
        PlayerModel playerModel = new PlayerModel();
        playerModel.addCard(Card.CardMaterialStone);
        playerModel.addCard(Card.CardMaterialBrick);
        playerModel.setWonder(WonderFactory.Alexandria.createWonder());
        game.addPlayer(playerModel);
        WonderFragment frag = playerModel.getWonder().getWonderFragments().get(0);
        // Act
        List<BuildWonderFragUsingCards> expected = new ArrayList<>();
        ImmutableMaterialCardByTypeCounts immutableMaterialCardByTypeCounts = new  ImmutableMaterialCardByTypeCounts.Builder()
                .with(Material.Stone, 1)
                .with(Material.Brick, 1)
                .build();
        expected.add(new BuildWonderFragUsingCards(game, frag, immutableMaterialCardByTypeCounts ));
        List<BuildWonderFragUsingCards> result = GameUtils.listMoveBuildWonderFragment(playerModel, frag, game);
        // Assert
        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertEquals(expected.get(0).cardsUsed.stoneCount, result.get(0).cardsUsed.stoneCount);
    }

    @Test
    void sameMaterial() {
        // Arrange
        GameModel game = new GameModel();
        PlayerModel playerModel = new PlayerModel();
        playerModel.addCard(Card.CardMaterialStone);
        playerModel.addCard(Card.CardMaterialStone);
        playerModel.setWonder(WonderFactory.Rhodes.createWonder());
        game.addPlayer(playerModel);
        WonderFragment frag = playerModel.getWonder().getWonderFragments().get(1);
        // Act
        List<BuildWonderFragUsingCards> expected = new ArrayList<>();
        ImmutableMaterialCardByTypeCounts immutableMaterialCardByTypeCounts = new  ImmutableMaterialCardByTypeCounts.Builder().with(Material.Stone, 2).build();
        expected.add(new BuildWonderFragUsingCards(game, frag, immutableMaterialCardByTypeCounts ));
        List<BuildWonderFragUsingCards> result = GameUtils.listMoveBuildWonderFragment(playerModel, frag, game);
        // Assert
        Assertions.assertEquals(expected.get(0).cardsUsed.stoneCount, result.get(0).cardsUsed.stoneCount);
    }

    @Test
    void getBuildingCombinations() {
        // Arrange
        // Arrange
        GameModel game = new GameModel();
        PlayerModel playerModel = new PlayerModel();
        playerModel.addCard(Card.CardMaterialStone);
        playerModel.addCard(Card.CardMaterialBrick);
        playerModel.setWonder(WonderFactory.Alexandria.createWonder());
        game.addPlayer(playerModel);
        game.setCurrentPlayer(playerModel);
        WonderFragment frag = playerModel.getWonder().getWonderFragments().get(0);
        // Act
        List<BuildWonderFragUsingCards> result = GameUtils.getBuildingCombinations(playerModel, game);
        // Assert
        System.out.println(result);
    }


    @Test
    void findCombinations() {
        //Arrange
        GameModel game = new GameModel();
        PlayerModel playerModel = new PlayerModel();
        playerModel.addCard(Card.CardMaterialGold);
        playerModel.addCard(Card.CardMaterialGold);
        playerModel.addCard(Card.CardMaterialGold);
        playerModel.addCard(Card.CardMaterialStone);
        playerModel.addCard(Card.CardMaterialBrick);
        playerModel.setWonder(WonderFactory.Alexandria.createWonder());
        game.addPlayer(playerModel);
        game.setCurrentPlayer(playerModel);
        WonderFragment frag = playerModel.getWonder().getWonderFragments().get(2);
        ImmutableMaterialCardByTypeCounts materialsMap = new ImmutableMaterialCardByTypeCounts(playerModel.getAvailableCardCounters());
        // Act
        List<BuildWonderFragUsingCards> result = GameUtils.findCombinations(materialsMap.getHashMap(), frag, game);
        // Assert
        System.out.println(result);
    }

    @Test
    void findInequalCombinationGold() {
        //Arrange
        GameModel game = new GameModel();
        PlayerModel playerModel = new PlayerModel();
        playerModel.addCard(Card.CardMaterialGold);
        playerModel.addCard(Card.CardMaterialStone);
        playerModel.setWonder(WonderFactory.Alexandria.createWonder());
        game.addPlayer(playerModel);
        game.setCurrentPlayer(playerModel);
        WonderFragment frag = playerModel.getWonder().getWonderFragments().get(0);
        ImmutableMaterialCardByTypeCounts materialsMap = new ImmutableMaterialCardByTypeCounts(playerModel.getAvailableCardCounters());
        // Act
        List<BuildWonderFragUsingCards> result = GameUtils.findCombinations(materialsMap.getHashMap(), frag, game);
        // Assert
        System.out.println(result);
    }
}