package fr.isep.javarchitects.core;

import fr.isep.javarchitects.model.command.GameAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Visible state of the game that will be passed to graphical interface
 */
public class GameStateVisible {

    public static final GameStateVisible BASE_STATE = new GameStateVisible(
            Arrays.asList(
                    new PlayerVisible.Builder()
                            .setName("Player 1")
                            .setWonder(WonderFactory.Alexandria.createWonder())
                            .setRightDeck(Card.CardMaterialGold, 20)
                            .setLeftDeck(Card.CardMaterialStone, 20)
                            .setHasCat(true)
                            .build(),

                    new PlayerVisible.Builder()
                        .setName("Player 2")
                        .setWonder(WonderFactory.Rhodes.createWonder())
                        .setRightDeck(Card.CardMaterialStone, 20)
                        .setLeftDeck(Card.CardMaterialGold, 20)
                        .setHasCat(false)
                        .build()
            ),
            0,
            Arrays.asList(
                    new ConflictToken(false),
                    new ConflictToken(true),
                    new ConflictToken(true)
            ),
            new ArrayList<>(ProgressTokens.TOKENS).subList(0,3)
    );

    public final List<PlayerVisible> players;
    public final int currentPlayerID;

    public final List<ConflictToken> conflictTokens;
    public final List<ProgressToken> visibleProgressTokens;
    public final List<GameAction> gameActionList;

    GameStateVisible(List<PlayerVisible> players, int currentPlayerID, List<ConflictToken> conflictTokens, List<ProgressToken> visibleProgressTokens){
        this.players = players;
        this.currentPlayerID = currentPlayerID;
        this.conflictTokens = conflictTokens;
        this.visibleProgressTokens = visibleProgressTokens;
        this.gameActionList = null;
    }

    public GameStateVisible(List<PlayerVisible> players, int currentPlayerID, List<ConflictToken> conflictTokens, List<ProgressToken> visibleProgressTokens, List<GameAction> gameActionList){
        this.players = players;
        this.currentPlayerID = currentPlayerID;
        this.conflictTokens = conflictTokens;
        this.visibleProgressTokens = visibleProgressTokens;
        this.gameActionList = gameActionList;
    }

    public PlayerVisible getCatOwner(List<PlayerVisible> playerList) {
        return playerList.stream()
                .filter(PlayerVisible::getHasCat)
                .findFirst()
                .orElse(null);
    }
}
