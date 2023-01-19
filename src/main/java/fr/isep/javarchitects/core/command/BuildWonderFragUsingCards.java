package fr.isep.javarchitects.core.command;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.WonderFragment;
import fr.isep.javarchitects.model.GameModel;

import java.util.List;

public class BuildWonderFragUsingCards extends GameAction {
    public final WonderFragment wonderFragment;
    public final List<Card> cardsUsed;

    public BuildWonderFragUsingCards(GameModel game, WonderFragment wonderFragment, List<Card> cardsUsed) {
        super(wonderFragment.toString(), game);
        this.wonderFragment = wonderFragment;
        this.cardsUsed = cardsUsed;
    }

    @Override
    public void execute() {

    }
}