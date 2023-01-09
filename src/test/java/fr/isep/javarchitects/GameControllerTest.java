package fr.isep.javarchitects;

import fr.isep.javarchitects.model.Player;
import fr.isep.javarchitects.model.Wonder;
import fr.isep.javarchitects.model.WonderFragment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameControllerTest {

    @Test
    void getBuildableFragments() {
        Player BabylonePlayer = new Player.Builder("Babylone", 1, Wonder.Babylone).build();

        List<WonderFragment> expected = new ArrayList<>();
    }
}