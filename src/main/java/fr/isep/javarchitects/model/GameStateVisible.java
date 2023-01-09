package fr.isep.javarchitects.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Visible state of the game that will be passed to graphical interface
 */
public class GameStateVisible {

    public static final GameStateVisible BASE_STATE = new GameStateVisible(
            Arrays.asList(
                    new PlayerVisible(Wonder.Alexandrie, new Card(CardType.CardMaterialGold, CardBack.Alexandrie), new ArrayList<>(), new ArrayList<>(), true),
                    new PlayerVisible(Wonder.Rhodes, new Card(CardType.CardMaterialStone, CardBack.Rhodes), new ArrayList<>(), new ArrayList<>(), false)
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

}
