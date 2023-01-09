package fr.isep.javarchitects.model;

//import fr.isep.javarchitects.Fenetres.FenetrePrincipale;
import fr.isep.javarchitects.GameController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Game {
    private GameController gameController;

    private int nbPlayers;
    private List<Player> players;
    private int currentPlayerID = 0;
    private int nbRound = 1;
    private List<GameAction> activeActionsList;

    public List<ConflictToken> conflictTokens = Arrays.asList(
            new ConflictToken(false),
            new ConflictToken(false),
            new ConflictToken(true)
    );
    private List<ProgressToken> progressTokenList = ProgressTokens.TOKENS.subList(5,11);

    // -----------------------------------------------------------------------------------------------------------------
    public Game(int nbPlayers, List<String> playerNames) {
        this.nbPlayers = nbPlayers;
        this.players = new ArrayList<>();
        for(int i = 0; i < this.nbPlayers; i++){
            players.add(new Player(playerNames.get(i), i, Wonder.Alexandrie));
        }
    }

    public void startGame(){

    };

    public void setNextPlayer() {
        currentPlayerID++;
        if (currentPlayerID >= this.nbPlayers) {
            this.currentPlayerID = 0;
            this.nbRound++;
        }
    }

    /**
     * Fonction qui va assigner à chaque joueur de listeJoueurs merveille.
     * De manière random
     * @param listePlayers liste des joueurs à traiter
     */
    public void setWonder(ArrayList<Player> listePlayers) {
        Random R = new Random();
        ArrayList<Wonder> listeWonder = new ArrayList<>();
        for (Wonder W : Wonder.values()) {
            listeWonder.add(W);
        }

        for (Player J : listePlayers) {
            int C = R.nextInt(listeWonder.size());
            J.setWonder(listeWonder.remove(C));
        }
    }

    /**
     * fonction qui va assigner à chaque joueur deux decks : son propre deck, positionné à sa gauche,
     * et le deck de son voisin de droite
     * @param listePlayers liste des joueurs ordonnée dans l'ordre
     */
    public void setDecks(ArrayList<Player> listePlayers) {
        ArrayList<Decks> decks = new ArrayList<>();
        for (Decks D : Decks.values()) {
            decks.add(D);
        }

        for (Player J : listePlayers) {
            J.setSelfDeck(decks.get(J.getWonder().getID()));
        }
        for (int i = listePlayers.size() - 1; i >= 0 ; i--) {
            Player player = listePlayers.get(i);
            if(i > 0) {
                player.setRightDeck(listePlayers.get(i - 1).getSelfDeck());
            }
            else {
                player.setRightDeck(listePlayers.get(listePlayers.size() - 1).getSelfDeck());
            }
        }
    }

    /**
     * 09/01/23 Moved from GameStateVisible
     * @param nbPlayers number of players in the game
     * @return the number of conflict tokens for the game
     */
    private int calcMaxConflictTokens(int nbPlayers){
        int ret=0;
        switch(nbPlayers){
            case 2:
            case 3:
                ret=3;
                break;
            case 4:
                ret=4;
                break;
            case 5:
                ret=5;
                break;
            case 6:
            case 7:
                ret=6;
                break;
        }
        return ret;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public void setController(GameController gameController) {
        this.gameController = gameController;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public List<Player> getPlayers() {
        return players;
    }
    public int getNbPlayers() {
        return nbPlayers;
    }
    public Player getCurrentPlayerID() {
        return players.get(currentPlayerID);
    }

    /**
     * @return the visible elements of the current state of the game
     */
    public GameStateVisible getVisibleState() {
        return new GameStateVisible(
                players.stream()
                        .map(Player::getVisibleState)
                        .collect(Collectors.toList()),
                0,
                conflictTokens,
                progressTokenList.subList(0,3),
                Arrays.asList(
                        new GameAction("Action 1", () -> {}),
                        new GameAction("Back", () -> {})
                )
        );
    }
}

