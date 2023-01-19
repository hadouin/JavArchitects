package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.WonderFragment;

import java.util.List;

public class BuildWonderFragUsingCards {
    public final WonderFragment wonderFragment;
    public final List<Card> cardsUsed;

    public BuildWonderFragUsingCards(WonderFragment wonderFragment, List<Card> cardsUsed) {
        this.wonderFragment = wonderFragment;
        this.cardsUsed = cardsUsed;
    }
}