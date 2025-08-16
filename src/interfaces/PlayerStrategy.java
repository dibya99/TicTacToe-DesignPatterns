package interfaces;

import entities.Board;
import utilities.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);
}
