package fr.isep.javarchitects.model.command;

import fr.isep.javarchitects.core.ProgressToken;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;

public class ResearchProgress extends GameAction {

    private final PlayerModel player;
    private final ProgressToken target;

    public ResearchProgress(GameModel game, PlayerModel player, ProgressToken target) {
        super(target.displayName, game);
        this.player = player;
        this.target = target;
    }

    @Override
    public boolean execute() {
        player.addProgress(target);
        game.getProgressTokensList().remove(target);
        game.chooseProgress();
        return true;
    }
}
