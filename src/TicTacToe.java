import util.Input;

import java.util.Arrays;

public class TicTacToe {

    public static void game() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Response Structure: (rowNumber)(columnLetter) / Ex. 1a, 3c");
        String[][] startBoard = startBoard();
        turn1(startBoard);

    }

    public static String[][] turn1(String[][] startBoard) {
        String player1 = new Input().getString("\nPlayer 1: ");
        String[] p1Breakdown = player1.split("");
        int row = (Integer.parseInt(p1Breakdown[0]));
        int column = positionToNum(p1Breakdown[1]);
        String[][] newBoard = newBoard(startBoard, row, column);
        return newBoard;
    }

    public static String[][] startBoard() {
        String[][] matrix = {
                {"   A   B   C  "},
                {"1", "---", "---", "---"},
                {"2", "---", "---", "---"},
                {"3", "---", "---", "---"},
        };
        for (String[] row : matrix) {
            System.out.print(" ");
            for (String n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static String[][] newBoard(String[][] oldMatrix, int row, int column) {
        String[][] newMatrix = Arrays.copyOf(oldMatrix, oldMatrix.length);
        newMatrix[row][column] = "-X-";
        for (String[] eachRow : newMatrix) {
            System.out.print(" ");
            for (String n : eachRow) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return newMatrix;
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
