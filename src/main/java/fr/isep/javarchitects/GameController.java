package fr.isep.javarchitects;

import fr.isep.javarchitects.JeuDePlateau.Joueur;
import fr.isep.javarchitects.model.WonderFragment;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    /**
     * @param joueur the player you want to test for
     * @return a list of WonderFragment the player can build from its wonder
     */
    public List<WonderFragment> getBuildableFragments(Joueur joueur){
        return new ArrayList<>();
    }
}
