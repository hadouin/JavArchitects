package fr.isep.javarchitects.core.command;

import fr.isep.javarchitects.core.WonderFragment;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.utils.ImmutableMaterialCardByTypeCounts;

public class BuildWonderFragUsingCards extends GameAction {
    public final WonderFragment wonderFragment;
    public final ImmutableMaterialCardByTypeCounts cardsUsed;

    public BuildWonderFragUsingCards(GameModel game, WonderFragment wonderFragment, ImmutableMaterialCardByTypeCounts cardsUsed) {
        super(wonderFragment.toString(), game);
        this.wonderFragment = wonderFragment;
        this.cardsUsed = cardsUsed;
    }

    @Override
    public void execute() {

    }
}