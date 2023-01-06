package fr.isep.javarchitects;

import fr.isep.javarchitects.model.Joueur;
import fr.isep.javarchitects.model.Wonder;
import fr.isep.javarchitects.model.WonderFragment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameControllerTest {

    @Test
    void getBuildableFragments() {
        Joueur BabylonePlayer = new Joueur.Builder("Babylone", 1).setWonder(Wonder.Babylone).build();

        List<WonderFragment> expected = new ArrayList<>();
    }
}