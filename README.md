# Designed TicTacToe Game using design patterns

# Strategy Design Pattern
There is an interface called PlayerStrategy which is implemented by HumanPlayerStrategy.
This interface is a part of the Player class. The idea is that the way a player chooses a move
can be defined by the implementations of the PlayerStrategy interface.

For example we can add something like AI strategy which will choose position based on different logic.

# State Design Pattern
Defined a game context which stores the game state
There are 5 states defined Xturn, Oturn, Xwins, Owins, Draw. 
These implement the GameState interface.

This can later allow us to introduce new states.