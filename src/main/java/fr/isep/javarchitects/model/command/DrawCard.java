package fr.isep.javarchitects.model.command;

import fr.isep.javarchitects.core.Card;
import fr.isep.javarchitects.core.CardCategory;
import fr.isep.javarchitects.model.GameModel;
import fr.isep.javarchitects.model.PlayerModel;

import java.util.List;

public class DrawCard extends GameAction{
    private final PlayerModel source;
    private final List<Card> target;
    private Card card;

    public DrawCard(GameModel game, String name, PlayerModel source, List<Card> target) {
        super(name, game);
        this.source = source;
        this.target = target;
    }

    @Override
    public boolean execute() {
        card = target.remove(0);
        source.addCard(card);
        
        if (card.cardCategory == CardCategory.MaterialCard) {
            game.buildWonder();
            return true;
        }
        if (card.cardCategory == CardCategory.ProgressCard) {
            game.chooseProgress();
            return true;
        }
        if (card == Card.CardWar_barbarian || card == Card.CardWar_archer){
            game.updateConflictState(card);
            return true;
        }
        game.nextPlayer();
        game.setDrawActions();
        return true;
    }

    @Override
    public String toString(){
        return source.getName() + " draw " + card.cardDisplayName;
    }
}
