package entities;

import interfaces.GameState;
import states.XturnState;
import states.XwinsState;

public class GameContext {
    private GameState gameState;

    GameContext() {
        gameState = new XturnState();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    void next(Player player, boolean wins, boolean draws) {
        gameState.next(this, player, wins, draws);
    }
}
