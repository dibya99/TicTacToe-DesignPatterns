package entities;

import interfaces.PlayerStrategy;
import utilities.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;

    HumanPlayerStrategy() {
        scanner = new Scanner(System.in);
    }

    public Position makeMove(Board board) {
        while (true) {
            try {
                int xVal, yVal;
                System.out.println("Enter X index");
                xVal = scanner.nextInt();
                System.out.println("Enter Y index");
                yVal = scanner.nextInt();

                Position position = new Position(xVal, yVal);
                if (board.isPositionValid(position))
                    return position;
                else
                    System.out.println("Wrong indexes, try again ");

            } catch (Exception e) {
                System.out.println("Some error, try again");
                System.out.println(e.getMessage());
                scanner.nextLine();
            }

        }
    }
}
