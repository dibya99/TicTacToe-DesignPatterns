package states;

import entities.GameContext;
import entities.Player;
import interfaces.GameState;

public class DrawState implements GameState {
    public void next(GameContext gameContext, Player player, boolean wins, boolean draws) {
        return ;
    }

    @Override
    public String toString() {
        return "DrawState{}";
    }
}
