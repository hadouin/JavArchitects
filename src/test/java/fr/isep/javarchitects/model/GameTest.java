package fr.isep.javarchitects.model;

import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getCatOwner() {
        Game game1 = new Game(2, List.of("Hadouin", "Romeo"));
        game1.setPlayers(Arrays.asList(
                new Player.Builder("Hadouin", 0, Wonder.Alexandrie).setOwnsCat(true).build(),
                new Player.Builder("Romeo", 1, Wonder.Alexandrie).build()
        ));
        String expected = "Hadouin";
        String result = game1.getCatOwner(game1.getPlayers()).getName();
        assertEquals(expected, result);
        Game game2 = new Game(2, List.of("Hadouin", "Romeo"));
        game2.setPlayers(Arrays.asList(
                new Player.Builder("Hadouin", 0, Wonder.Alexandrie).build(),
                new Player.Builder("Romeo", 1, Wonder.Alexandrie).build()
        ));
        Player expected2 = null;
        Player result2 = game2.getCatOwner(game2.getPlayers());
        assertEquals(expected2, result2);
    }

    @Nested
    class GetBuildableFragments {

        @Test
        void assert0Rhodes2stone() {
            Player player = new Player.Builder("Hadouin", 0, Wonder.Rhodes)
                    .setOwnedCards(Arrays.asList(
                            new Card(CardType.CardMaterialStone, CardBack.Rhodes),
                            new Card(CardType.CardMaterialStone, CardBack.CentralDeck)
                    )).build();
            Game game = new Game(1, List.of("Hadouin"));
            game.setPlayers(List.of(player));
            List<WonderFragment> expected = player.getWonder().getWonderFragments().subList(1, 2);
            List<WonderFragment> result = game.getBuildableFragments(player);
            assertEquals(expected, result);
        }

        @Test
        void assert0Rhodes1stone1gold() {
            Player player = new Player.Builder("Hadouin", 0, Wonder.Rhodes)
                    .setOwnedCards(Arrays.asList(
                            new Card(CardType.CardMaterialStone, CardBack.Rhodes),
                            new Card(CardType.CardMaterialGold, CardBack.CentralDeck)
                    )).build();
            Game game = new Game(1, List.of("Hadouin"));
            game.setPlayers(List.of(player));
            List<WonderFragment> expected = player.getWonder().getWonderFragments().subList(0, 2);
            List<WonderFragment> result = game.getBuildableFragments(player);
            assertEquals(expected, result);
        }

        @Test
        void assert0Rhodes1stone1wood() {
            Player player = new Player.Builder("Hadouin", 0, Wonder.Rhodes)
                    .setOwnedCards(Arrays.asList(
                            new Card(CardType.CardMaterialStone, CardBack.Rhodes),
                            new Card(CardType.CardMaterialWood, CardBack.CentralDeck)
                    )).build();
            Game game = new Game(1, List.of("Hadouin"));
            game.setPlayers(List.of(player));

            List<WonderFragment> expected = player.getWonder().getWonderFragments().subList(0, 1);

            List<WonderFragment> result = game.getBuildableFragments(player);
            assertEquals(expected, result);
        }

        @Test
        void assert1Alexandria2Stone2Gold(){
            Player player = new Player.Builder("1Alexandria2Stone2Gold", 0, Wonder.Alexandrie)
                    .setOwnedCards(Arrays.asList(
                            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
                            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
                            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),
                            new Card(CardType.CardMaterialGold, CardBack.CentralDeck)
                    )).build();
            player.getWonder().getWonderFragments().get(0).build();
            Game game = new Game(1,List.of("Hadouin"));
            game.setPlayers(List.of(player));

            List<WonderFragment> expected = player.getWonder().getWonderFragments().subList(1, 2);

            List<WonderFragment> result = game.getBuildableFragments(player);
            assertEquals(expected, result);
        }

        @Test
        void assert1Ephese2Stone2Gold(){
            Player player = new Player.Builder("1Alexandria2Stone2Gold", 0, Wonder.Ephese)
                    .setOwnedCards(Arrays.asList(
                            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
                            new Card(CardType.CardMaterialStone, CardBack.CentralDeck),
                            new Card(CardType.CardMaterialGold, CardBack.CentralDeck),
                            new Card(CardType.CardMaterialGold, CardBack.CentralDeck)
                    )).build();
            player.getWonder().getWonderFragments().get(0).build();
            Game game = new Game(1,List.of("Hadouin"));
            game.setPlayers(List.of(player));

            List<WonderFragment> expected = player.getWonder().getWonderFragments().subList(1, 4);

            List<WonderFragment> result = game.getBuildableFragments(player);
            assertEquals(expected, result);
        }
    }
}