package entities;

import interfaces.PlayerStrategy;
import utilities.Symbol;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerStrategy playerStrategy;

    public Player(String name, Symbol symbol, PlayerStrategy playerStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
