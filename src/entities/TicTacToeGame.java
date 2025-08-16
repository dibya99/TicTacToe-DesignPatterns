package entities;

import interfaces.BoardGame;
import states.DrawState;
import states.OturnState;
import states.XturnState;
import states.XwinsState;
import utilities.Position;
import utilities.Symbol;

public class TicTacToeGame implements BoardGame {
    private Board board;
    private Player XPlayer;
    private Player OPlayer;
    private Player currPlayer;
    private GameContext gameContext;

    public TicTacToeGame() {
        board = new Board();
        XPlayer = new Player("Dibya", Symbol.X, new HumanPlayerStrategy());
        OPlayer = new Player("Satish", Symbol.O, new HumanPlayerStrategy());
        currPlayer = XPlayer;
        gameContext = new GameContext();
    }

    private void switchPlayers()
    {
        if(currPlayer==XPlayer)
            currPlayer=OPlayer;
        else
            currPlayer=XPlayer;
    }
    public void play() {
        while (gameContext.getGameState() instanceof XturnState || gameContext.getGameState() instanceof OturnState) {
            System.out.println("Current Game State");
            System.out.println(gameContext.getGameState());
            System.out.println("Current Board");
            board.showBoard();
            Position position = currPlayer.getPlayerStrategy().makeMove(board);
            board.setMove(currPlayer,position);
            board.checkContext(currPlayer,gameContext);
            switchPlayers();
        }
        if(gameContext.getGameState() instanceof DrawState)
            System.out.println("Draw Happened");
        else if(gameContext.getGameState() instanceof XwinsState)
            System.out.println("X wins");
        else
            System.out.println("O wins");
    }
}
