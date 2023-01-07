package fr.isep.javarchitects;

/**
 * Simple Interface to define the update method the different observers.
 * In our case GameUI implements it.
 */
public interface Subscriber {
    /**
     * Update subscribers in our case mainly our GUIs
     * @param testState game state containing visible elements you want to display
     */
    void update(TestState testState);
}
