package fr.isep.javarchitects.model;

import fr.isep.javarchitects.model.command.GameAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Visible state of the game that will be passed to graphical interface
 */
public class GameStateVisible {

    public static final GameStateVisible BASE_STATE = new GameStateVisible(
            Arrays.asList(
                    new PlayerVisible.Builder()
                            .setName("Player 1")
                            .setWonder(WonderFactory.Halicarnassus.createWonder())
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
                    new ConflictToken(false),
                    new ConflictToken(false)
            ),
            new ArrayList<>(ProgressTokens.createTokenList()).subList(0,3)
    );

    public final List<PlayerVisible> players;
    public final int currentPlayerID;

    public final List<ConflictToken> conflictTokens;
    public final List<ProgressToken> visibleProgressTokens;
    public final List<GameAction> gameActionList;

    public GameStateVisible(Game game) {
        this.players = setUpPlayers(game);
        this.conflictTokens = game.conflictTokens;
        this.currentPlayerID = 0;
        this.visibleProgressTokens = ProgressTokens.TOKENS;
        this.gameActionList = null;

    }

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

    private List<PlayerVisible> setUpPlayers (Game game) {
        List<PlayerVisible> playerVisibleList = new ArrayList<>();

        for (Player player : game.getPlayers()) {
            playerVisibleList.add(new PlayerVisible.Builder()
                    .setName(player.getName())
                    .setWonder(player.getWonder())
                    .setRightDeck(player.getRightDeck().getFirstCard(), 20)
                    .setLeftDeck(player.getSelfDeck().getFirstCard(), 20)
                    .setHasCat(true)
                    .build());
        }

        return playerVisibleList;
    }

    private List<ProgressToken> setVisibleProgressToken() {
        List<ProgressToken> progressTokenList = new ArrayList<>(ProgressTokens.TOKENS);
        List<ProgressToken> progressTokenListShuffled = new ArrayList<>();
        for (ProgressToken progressToken : progressTokenList) {
            progressTokenListShuffled.add(progressToken);
        }
        Collections.shuffle(progressTokenListShuffled);

        return progressTokenListShuffled;
    }
}
