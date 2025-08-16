package interfaces;

import entities.GameContext;
import entities.Player;

public interface GameState {
    void next(GameContext gameContext, Player player, boolean wins, boolean draw);
}
