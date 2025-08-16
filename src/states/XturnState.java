package states;

import entities.GameContext;
import entities.Player;
import interfaces.GameState;
import utilities.Symbol;

public class XturnState implements GameState {
    @Override
    public String toString() {
        return "XturnState{}";
    }

    public void next(GameContext gameContext, Player player, boolean wins, boolean draws) {
        if (draws)
            gameContext.setGameState(new DrawState());
        else if (wins && player.getSymbol() == Symbol.O)
            gameContext.setGameState(new OwinsState());
        else if (wins && player.getSymbol() == Symbol.X)
            gameContext.setGameState(new XwinsState());
        else
            gameContext.setGameState(new OturnState());
    }
}
