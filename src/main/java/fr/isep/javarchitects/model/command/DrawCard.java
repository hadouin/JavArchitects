package fr.isep.javarchitects.model.command;

import fr.isep.javarchitects.model.Card;
import fr.isep.javarchitects.model.Game;
import fr.isep.javarchitects.model.Player;

import java.util.List;

public class DrawCard extends GameAction{
    private final Player source;
    private final List<Card> target;

    public DrawCard(Game game, String name, Player source, List<Card> target) {
        super(name, game);
        this.source = source;
        this.target = target;
    }

    @Override
    public void execute() {
        Card card = target.remove(0);
        source.addCard(card);
        game.startDrawPhase();
        System.out.println(source.getName() + " drew " + card.cardDisplayName);
    }
}
