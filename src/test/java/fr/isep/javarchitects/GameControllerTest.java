package fr.isep.javarchitects;

import fr.isep.javarchitects.core.Player;
import fr.isep.javarchitects.core.WonderFactory;
import fr.isep.javarchitects.core.WonderFragment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameControllerTest {

    @Test
    void getBuildableFragments() {
        Player BabylonePlayer = new Player.Builder("Babylone", 1, WonderFactory.Babylon.createWonder()).build();

        List<WonderFragment> expected = new ArrayList<>();
    }
}