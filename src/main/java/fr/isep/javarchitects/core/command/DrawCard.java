package fr.isep.javarchitects.core.command;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.Player;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;

import java.util.List;

public class DrawCard extends GameAction{
    private final PlayerModel source;
    private final List<Card> target;

    public DrawCard(GameModel game, String name, PlayerModel source, List<Card> target) {
        super(name, game);
        this.source = source;
        this.target = target;
    }

    @Override
    public void execute() {
        Card card = target.remove(0);
        source.addCard(card);
        System.out.println(source.getName() + " drew " + card.cardDisplayName);
        game.nextPlayer();
    }
}
