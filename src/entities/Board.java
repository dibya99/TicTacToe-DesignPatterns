package entities;

import utilities.Position;
import utilities.Symbol;

public class Board {
    private Symbol[][] grid = new Symbol[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isPositionValid(Position position) {
        if (position.getxVal() >= 0
                && position.getxVal() < 3
                && position.getyVal() >= 0
                && position.getyVal() < 3
                && grid[position.getxVal()][position.getyVal()] == Symbol.EMPTY)
            return true;
        return false;
    }

    public void showBoard() {
        System.out.println("Showing the current grid");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + "      ");
            }
            System.out.println();
        }
    }

    public void setMove(Player player, Position position) {
        grid[position.getxVal()][position.getyVal()] = player.getSymbol();
    }

    public void checkContext(Player player, GameContext gameContext) {
        Symbol symbol = player.getSymbol();
        boolean isWin = false;
        // check if any row is filled
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == symbol)
                    count++;
            }
            if (count == 3) {
                gameContext.next(player, true, false);
                return;
            }
        }

        // check if column is filled

        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[j][i] == symbol)
                    count++;
            }

            if (count == 3) {
                gameContext.next(player, true, false);
                return;
            }
        }


        // check if 1st diagonal is filled
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < 3; i++) {
            if (grid[i][i] == symbol)
                count++;
            if (grid[i][2 - i] == symbol)
                count2++;
        }

        if (count == 3 || count2 == 3) {
            gameContext.next(player, true, false);
            return;
        }

        int count_empty = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == Symbol.EMPTY)
                    count_empty++;
            }
        }
        if (count_empty == 0) {
            gameContext.next(player, false, true);
            return;
        }

        gameContext.next(player, false, false);


    }


}
