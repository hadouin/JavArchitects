package fr.isep.javarchitects.command;

import fr.isep.javarchitects.model.Material;
import fr.isep.javarchitects.model.WonderFragment;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;
import fr.isep.javarchitects.utils.ImmutableMaterialCardByTypeCounts;

public class BuildWonderFragUsingCards extends GameAction {
    public final WonderFragment wonderFragment;
    public final ImmutableMaterialCardByTypeCounts cardsUsed;
    private final PlayerModel player;

    public BuildWonderFragUsingCards(GameModel game, WonderFragment wonderFragment, ImmutableMaterialCardByTypeCounts cardsUsed) {
        super(getName(wonderFragment, cardsUsed), game);
        player = game.getCurrentPlayer();
        this.wonderFragment = wonderFragment;
        this.cardsUsed = cardsUsed;
    }

    private static String getName(WonderFragment wonderFragment, ImmutableMaterialCardByTypeCounts cardsUsed) {
        StringBuilder name = new StringBuilder("build " + wonderFragment.getResourceCount() +
                (wonderFragment.isMatchingResources() ? "=" : "!="));
        for (Material material : Material.values()){
            int n = cardsUsed.get(material);
            if ( n > 0){
                name.append(" ")
                        .append(n)
                        .append(material.name().charAt(0));
            }
        }
        return name.toString();
    }

    @Override
    public boolean execute() {
        game.getCurrentPlayer().removeMaterialCardByTypeCounts(cardsUsed);
        wonderFragment.build();
        game.nextPlayer();
        game.setDrawActions();
        return true;
    }

    @Override
    public String toString(){
        return player.getName() +
                " built " + wonderFragment.getResourceCount() +
                (wonderFragment.isMatchingResources() ? "=" : "!=") +
                " fragment";
    }
}