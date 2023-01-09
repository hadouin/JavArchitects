package fr.isep.javarchitects.model;

import org.junit.Assert;
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
}