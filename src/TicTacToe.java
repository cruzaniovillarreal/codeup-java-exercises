import util.Input;

public class TicTacToe {

    public static void game() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Response Structure: (rowNumber)(columnLetter) / Ex. 1a, 3c");
        gameBoard();
        String player1 = new Input().getString("\nPlayer 1: ");
    }

    public static String[][] gameBoard() {
        String[][] matrix = {
                {"1", "---", "---", "---"},
                {"2","---", "---", "---"},
                {"3","---", "---", "---"},
        };
        System.out.println("    A   B   C  ");
        for (String[] row : matrix) {
            System.out.print(" ");
            for (String n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static String[] usableLocation(String[] userInput) {

    }

    public static int positionToNum(String position) {
        int letterToNum = 0;
        switch (position) {
            case "a":
                letterToNum = 1;
                break;
            case "b":
                letterToNum = 2;
                break;
            case "c":
                letterToNum = 3;
                break;
        }
        return letterToNum;


    }

    public static void main(String[] args) {
        game();
    }
}
