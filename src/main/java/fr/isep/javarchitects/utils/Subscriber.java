package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.core.GameStateVisible;

/**
 * Simple Interface to define the update method the different observers.
 * In our case GameUI implements it.
 */
public interface Subscriber {
    /**
     * Update subscribers in our case mainly our GUIs
     * @param gameStateVisible game state containing visible elements you want to display
     */
    void update(GameStateVisible gameStateVisible);
}
