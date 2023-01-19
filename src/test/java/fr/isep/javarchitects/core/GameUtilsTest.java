package fr.isep.javarchitects.core;

import fr.isep.javarchitects.model.command.BuildWonderFragUsingCards;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.utils.ImmutableMaterialCardByTypeCounts;
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
}